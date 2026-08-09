package com.myproject.microgreenapp.requests;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	
	private long contactNo;
	private List<OrderItemRequest> items;

}
