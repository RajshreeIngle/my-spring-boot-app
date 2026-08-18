package com.myproject.microgreenapp.exceptionhandling;

public class EmailAlreadyExistsException extends RuntimeException {
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}

}
