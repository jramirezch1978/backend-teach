package com.mindefdb.services.transactionals.Exceptiones;

public class AccountNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486937722314895409L;
	
	public AccountNotFoundException(String mensaje) {
		super(mensaje);
	}

}
