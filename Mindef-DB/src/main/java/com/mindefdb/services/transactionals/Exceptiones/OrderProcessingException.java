package com.mindefdb.services.transactionals.Exceptiones;

public class OrderProcessingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486937722314895409L;
	
	public OrderProcessingException(String mensaje) {
		super(mensaje);
	}

}
