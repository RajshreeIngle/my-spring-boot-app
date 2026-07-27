package com.myproject.microgreenapp.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.repository.MyCustomerRepository;

@Service
public class MyCustomerService {
	
	MyCustomerRepository myCustomerRepository;

	public List<Customer> getAllCustomer() {
		return myCustomerRepository.findAll();
	}

	public Customer getCustomerByContactno(int contact_no) {
		return myCustomerRepository.findById(contact_no).orElse(null);
	}

	public Customer addCustomer(Customer customer) {
		return myCustomerRepository.save(customer);
	}

	public Customer updateCustomer(int contact, Customer customer) {
		Customer updatedCustomer = myCustomerRepository.findById(contact).orElse(null);
		if(updatedCustomer != null && customer.getContactNo() == contact) {
			return myCustomerRepository.save(customer);	
		}else if(updatedCustomer != null && customer.getContactNo() != contact) {
			customer.setContactNo(contact);
			return myCustomerRepository.save(customer);
		}
		return updatedCustomer;
		
	}
	
	
	
	
	

}
