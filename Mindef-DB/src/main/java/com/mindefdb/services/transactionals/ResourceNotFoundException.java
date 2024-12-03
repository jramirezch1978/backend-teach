package com.mindefdb.services.transactionals;

public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3068179733398533975L;
	
	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}

}
