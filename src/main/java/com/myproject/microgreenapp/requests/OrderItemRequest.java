package com.myproject.microgreenapp.requests;

import lombok.Data;

@Data
public class OrderItemRequest {
	
	private int p_id;
	private int quantity;
}
