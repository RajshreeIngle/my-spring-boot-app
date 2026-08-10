package com.myproject.microgreenapp.exceptionhandling;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
