package com.myproject.microgreenapp.services;

import com.myproject.microgreenapp.controller.MyCustomerController;
import com.myproject.microgreenapp.dtos.CustomerDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.repository.MyCustomerRepository;

@Service
public class MyCustomerService {
	@Autowired
	MyCustomerRepository myCustomerRepository;

	public List<Customer> getAllCustomer() {
		return myCustomerRepository.findAll();
	}

	public Customer getCustomerByContactno(long contact_no) {
		return myCustomerRepository.findById(contact_no).orElse(null);
	}

	public Customer addCustomer(Customer customer) {
		return myCustomerRepository.save(customer);
	}

	public Customer updateCustomer(long contact, Customer customer) {
		Customer updatedCustomer = myCustomerRepository.findById(contact).orElse(null);
		if(updatedCustomer != null && customer.getContactNo() == contact) {
			return myCustomerRepository.save(customer);	
		}else if(updatedCustomer != null && customer.getContactNo() != contact) {
			customer.setContactNo(contact);
			return myCustomerRepository.save(customer);
		}
		return updatedCustomer;
		
	}


	public String deleteCustomer(long contact) {
		if(myCustomerRepository.existsById(contact)){
			 myCustomerRepository.deleteById(contact);
		 }else {
			 return "Customer entry does not exists";
		 }
		 return "success";
	}
	
}
