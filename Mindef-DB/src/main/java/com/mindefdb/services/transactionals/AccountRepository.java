package com.mindefdb.services.transactionals;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindefdb.services.transactionals.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
