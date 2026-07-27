package com.myproject.microgreenapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.services.MyCustomerService;

@RestController
@RequestMapping("/customer")
public class MyCustomerController {
	MyCustomerService myCustomerService;
	
	//fetching all customers list
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers(){
		return myCustomerService.getAllCustomer();
	}
	
	//fetching cutomers by contact no
	@GetMapping("/getcustomerbycontactno/{contact_no}")
	public Customer getCustomerByContactno(@PathVariable int contact_no) {
		return myCustomerService.getCustomerByContactno(contact_no);
	}
	
	//Adding new customer
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return myCustomerService.addCustomer(customer);	
	}
	
	//updating customer data
	@PutMapping("/updatecustomer/{contact}")
	public Customer updateCustomer(@PathVariable int contact, @RequestBody Customer customer){
		return myCustomerService.updateCustomer(contact, customer);
	}
	
}
