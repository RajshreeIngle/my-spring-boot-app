package com.myproject.microgreenapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException("Customer Not Found"));
		
		return User.builder()
				.username(customer.getEmail())
				.password(customer.getPassword())
				.roles("CUSTOMER")
				.build();
	}

}
