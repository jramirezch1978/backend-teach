package com.mindefdb.services.transactionals.Exceptiones;

public class InsufficientFundsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486937722314895409L;
	
	public InsufficientFundsException(String mensaje) {
		super(mensaje);
	}

}
