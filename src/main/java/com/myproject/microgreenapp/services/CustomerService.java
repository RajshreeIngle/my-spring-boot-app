package com.myproject.microgreenapp.services;

import com.myproject.microgreenapp.controller.MyCustomerController;
import com.myproject.microgreenapp.dtos.CustomerDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.exceptionhandling.EmailAlreadyExistsException;
import com.myproject.microgreenapp.exceptionhandling.ResourceNotFoundException;
import com.myproject.microgreenapp.repository.CustomerRepository;
import com.myproject.microgreenapp.requests.CustomerRegisterRequest;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository myCustomerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Customer> getAllCustomer() {
		return myCustomerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return myCustomerRepository.save(customer);
	}

	public Customer getCustomerById(long id) {
		Customer customer = myCustomerRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Customer not Found"));
		return customer;
	}
	
	public Customer updateCustomer(long id, Customer customer) {
	    if (!myCustomerRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Customer not found");
	    }
	    customer.setCustomerId(id);
	    return myCustomerRepository.save(customer);
	}
	
	public String deleteCustomer(long id) {
		if(myCustomerRepository.existsById(id)){
			 myCustomerRepository.deleteById(id);
		 }else {
			 throw new ResourceNotFoundException("Customer not found");
		 }
		 return "success";
	}
	
	public Customer register(CustomerRegisterRequest request) {
		if(myCustomerRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyExistsException("Email Already Registered");
		}
		
		Customer customer = new Customer();
		customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setContactNo(request.getContactNo());

        customer.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        return myCustomerRepository.save(customer);
	}
}
