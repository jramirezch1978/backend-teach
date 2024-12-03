package com.mindefdb.services.transactionals;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.services.transactionals.Exceptiones.AccountNotFoundException;
import com.mindefdb.services.transactionals.Exceptiones.InsufficientFundsException;
import com.mindefdb.services.transactionals.entities.Account;

@Service
public class TransferService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
    public void transferMoney(Long fromAccount, Long toAccount, BigDecimal amount) throws AccountNotFoundException, 
    																					  InsufficientFundsException
	{
		
		//Identacion Horizontal / Vertical
        Account from = accountRepository.findById(fromAccount)
            .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        Account to = accountRepository.findById(toAccount)
            .orElseThrow(() -> new AccountNotFoundException("Account not found"));
            
        if (from.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds");
            // Esto causará rollback automático
        }
        
        from.debit(amount);
        to.credit(amount);
        
        accountRepository.save(from);
        accountRepository.save(to);
        // Si todo sale bien, se hace commit automático
    }
}
