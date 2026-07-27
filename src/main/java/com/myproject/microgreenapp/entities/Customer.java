package com.myproject.microgreenapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="customer")
@Entity
public class Customer {
	
	@Id
	private int contactNo;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private int pincode;
	private String state;
	private String email;
	
}
