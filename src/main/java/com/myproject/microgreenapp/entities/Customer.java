package com.myproject.microgreenapp.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name="customer")
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotNull(message = "Contact number cannot be null")
//	@Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits")
	@Digits(integer = 10, fraction = 0, message = "Invalid contact, only numbers allowed")
	@Column(unique = true, nullable = false)
	private long contactNo;
	
	@NotBlank
	private String name;

	private String address;
	private String city;
	private int pincode;
	private String state;
	@Column(unique = true, nullable = false)
	private String email;
	@NotBlank
	@Column(nullable = false)
	private String password;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
}
