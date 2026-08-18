package com.myproject.microgreenapp.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegisterRequest {
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min= 6)
	private String password;
	
//	@Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits")
	@Digits(integer = 10, fraction = 0, message = "Invalid contact, only numbers allowed")
	@Column(unique = true, nullable = false)
	private long contactNo;
	
}
