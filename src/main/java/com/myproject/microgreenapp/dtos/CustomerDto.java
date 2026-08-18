package com.myproject.microgreenapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
	private long customerId;
	private long contactNo;
	private String name;
	private String address;
	private String city;
	private int pincode;
	private String state;
	private String email;
}
