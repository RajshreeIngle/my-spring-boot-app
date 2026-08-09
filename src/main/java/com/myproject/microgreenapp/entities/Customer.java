package com.myproject.microgreenapp.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table(name="customer")
@Entity
public class Customer {
	@Digits(integer= 10, message="Invalid contact, contact number should be 10 digits", fraction = 0)
	@Id
	private long contactNo;
	@NotBlank
	private String firstName;
	private String lastName;
	@NotBlank
	private String address;
	private String city;
	private int pincode;
	private String state;
	private String email;
	@NotBlank
	private String password;	
	
//	mapping changes done here dt 01-08
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
}
