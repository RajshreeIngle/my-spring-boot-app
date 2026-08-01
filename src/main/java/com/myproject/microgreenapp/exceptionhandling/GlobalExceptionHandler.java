package com.myproject.microgreenapp.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myproject.microgreenapp.exceptionhandling.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String handlerProductNotFoundException(ProductNotFoundException p) {
		return p.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errorMap= new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(ObjectError->{
			String filedName=e.getFieldError().getField();
			String errorMessage = e.getFieldError().getDefaultMessage();
			errorMap.put(filedName, errorMessage);
		});
	return ResponseEntity.badRequest().body(errorMap);
	}
}
