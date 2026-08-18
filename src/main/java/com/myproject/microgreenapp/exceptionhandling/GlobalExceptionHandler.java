package com.myproject.microgreenapp.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.myproject.microgreenapp.exceptionhandling.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handlerProductNotFoundException(ProductNotFoundException p) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(p.getMessage());
	}
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<String> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

	    @ExceptionHandler(InsufficientStockException.class)
	    public ResponseEntity<String> handleStock(
	            InsufficientStockException ex) {

	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(ex.getMessage());
	    }
	    
	    @ExceptionHandler(EmailAlreadyExistsException.class)
	    public ResponseEntity<String> handleEmailException(
	    		EmailAlreadyExistsException e){
	    	return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
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
