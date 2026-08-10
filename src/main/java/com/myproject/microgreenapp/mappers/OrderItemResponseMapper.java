package com.myproject.microgreenapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.myproject.microgreenapp.dtos.OrderItemResponse;
import com.myproject.microgreenapp.entities.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemResponseMapper {
	
	@Mapping(source="product.p_name", target="productName")
	@Mapping(
			target="subtotal", 
			expression = "java(orderItem.getPrice()*orderItem.getQuantity())")
	OrderItemResponse toOrderItemResponse(OrderItem orderItem);

}
