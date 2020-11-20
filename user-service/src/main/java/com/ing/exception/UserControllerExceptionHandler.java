package com.ing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class UserControllerExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Userid should be numeric");
	}

	@ExceptionHandler(UnAuthorizedUser.class)
	public ResponseEntity<?> unAuth(UnAuthorizedUser ex){
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorised User for this operation");
	}
	
	@ExceptionHandler(UserIDFormatException.class)
	public ResponseEntity<?> userIdformat(UserIDFormatException ex){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserID should be numeric");
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFound(UserNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> generic(Exception ex){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
	
	
}
