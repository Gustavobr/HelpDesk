package br.com.qintess.resources.exceptions;

public class DataIntegrityViolationData extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationData(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataIntegrityViolationData(String message) {
		super(message);
		
	}
	
	
	

}
