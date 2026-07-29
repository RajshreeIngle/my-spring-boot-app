package com.myproject.microgreenapp.dtos;

import lombok.Data;

@Data
public class CustomerDto {
	private long contactNo;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private int pincode;
	private String state;

}
