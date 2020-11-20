package com.ing.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	} 
	
	public UserNotFoundException(String message, Throwable throwable) {
		super(message,throwable);
		// TODO Auto-generated constructor stub
	} 
	
	
	

}
