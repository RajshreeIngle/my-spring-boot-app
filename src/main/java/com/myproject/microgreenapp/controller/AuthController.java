package com.myproject.microgreenapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.dtos.CustomerDto;
import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.mappers.CustomerMapper;
import com.myproject.microgreenapp.requests.CustomerRegisterRequest;
import com.myproject.microgreenapp.requests.LoginRequest;
import com.myproject.microgreenapp.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> register(
			@Valid @RequestBody CustomerRegisterRequest request){
		
		Customer customer = customerService.register(request);
		System.out.println(customer.toString());
		 return ResponseEntity.ok(
	                customerMapper.toCustomerDto(customer)
	        );
	}
	
	 @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return ResponseEntity.ok("Login successful");
    }

}
