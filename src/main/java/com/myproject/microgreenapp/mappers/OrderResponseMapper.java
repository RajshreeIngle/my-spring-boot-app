package com.myproject.microgreenapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.myproject.microgreenapp.dtos.OrderResponse;
import com.myproject.microgreenapp.entities.Order;

@Mapper(
		componentModel = "spring", 
		uses = OrderItemResponseMapper.class)
public interface OrderResponseMapper {
	@Mapping(source = "orderItems", target = "items")
	OrderResponse toOrderResponse(Order order);

}
