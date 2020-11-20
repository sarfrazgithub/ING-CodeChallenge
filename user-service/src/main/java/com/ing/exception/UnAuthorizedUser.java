package com.ing.exception;

public class UnAuthorizedUser extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnAuthorizedUser(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	} 
	public UnAuthorizedUser(String message, Throwable throwable) {
		super(message,throwable);
		// TODO Auto-generated constructor stub
	} 
	
}