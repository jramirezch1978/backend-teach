package com.mindefdb.services.transactionals.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_account", columnDefinition = "NUMERIC(8,0)")
	private Long IdAccount;
	
	private String nombre;
	private String apellidos;
	private String razonSocial;
	private String direccion;
	private BigDecimal balance;
	
	public void debit(BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}
	public void credit(BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

}
