package com.ing.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserIDFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserIDFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	} 
	
	public UserIDFormatException(String message, Throwable throwable) {
		super(message,throwable);
		// TODO Auto-generated constructor stub
	} 
	
	
	

}
