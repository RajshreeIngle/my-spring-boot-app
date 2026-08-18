package com.myproject.microgreenapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.dtos.CustomerDto;
import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.mappers.CustomerMapper;
import com.myproject.microgreenapp.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class MyCustomerController {
	
	@Autowired
	private CustomerService myCustomerService;

	//DTO object return for customer
	@Autowired
	private CustomerMapper customerMapper;
	
	//fetching all customers list
	@GetMapping("/getallcustomers")
	public List<CustomerDto> getAllCustomers(){
		List<Customer> customerList =  myCustomerService.getAllCustomer();
		List<CustomerDto> customerDtoList = customerList.stream().map((customer)-> customerMapper.toCustomerDto(customer)).toList();
		return customerDtoList;  // dto java object to hide password and other sensitive data
	}
	
//	//fetching customers by contact no
//	@GetMapping("/getcustomerbycontactno/{contact_no}")
//	public ResponseEntity<CustomerDto> getCustomerByContactno(@PathVariable long contact_no) {
//		Customer customer =  myCustomerService.getCustomerByContactno(contact_no);
//		if(customer == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(customerMapper.toCustomerDto(customer));
//	}
	
	//fetching customers by contact no
	@GetMapping("/getcustomerbyid/{id}")
	public ResponseEntity<CustomerDto> getCustomerByContactno(@PathVariable long id) {
		Customer customer =  myCustomerService.getCustomerById(id);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customerMapper.toCustomerDto(customer));
	}
	
	//Adding new customer
	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody Customer customer) {
		return ResponseEntity.ok()
				.body(customerMapper
						.toCustomerDto(
								myCustomerService.addCustomer(customer)));	
	}
	
	//updating customer data
//	@PutMapping("/updatecustomer/{contact}")
//	public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable long contact, @RequestBody Customer customer){
//		Customer updatedCustomer = myCustomerService.updateCustomer(contact, customer);
//		if(updatedCustomer == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(customerMapper.toCustomerDto(updatedCustomer));
//	}
	
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable long id, @RequestBody Customer customer){
		Customer updatedCustomer =  myCustomerService.updateCustomer(id, customer);
		return ResponseEntity.ok().body(customerMapper.toCustomerDto(updatedCustomer));
	}
	
	@DeleteMapping("/deletecustomer/{contact}")
	public String deleteCustomer(@Valid @PathVariable long contact) {
		return myCustomerService.deleteCustomer(contact);
	}
	
}
