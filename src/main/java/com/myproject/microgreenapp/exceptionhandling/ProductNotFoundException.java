package com.myproject.microgreenapp.exceptionhandling;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException() {
		super("Requested Product not found");
	}

}
