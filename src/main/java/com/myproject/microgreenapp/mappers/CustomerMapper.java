package com.myproject.microgreenapp.mappers;

import org.mapstruct.Mapper;

import com.myproject.microgreenapp.dtos.CustomerDto;
import com.myproject.microgreenapp.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	CustomerDto toCustomerDto(Customer customer);

}
