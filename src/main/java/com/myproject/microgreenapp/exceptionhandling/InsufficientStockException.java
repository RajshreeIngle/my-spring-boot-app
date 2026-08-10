package com.myproject.microgreenapp.exceptionhandling;

public class InsufficientStockException extends RuntimeException {
	
	public InsufficientStockException(String message) {
		super(message);
	}

}
