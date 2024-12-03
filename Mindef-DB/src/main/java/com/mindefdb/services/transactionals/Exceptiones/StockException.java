package com.mindefdb.services.transactionals.Exceptiones;

public class StockException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486937722314895409L;
	
	public StockException(String mensaje) {
		super(mensaje);
	}

}