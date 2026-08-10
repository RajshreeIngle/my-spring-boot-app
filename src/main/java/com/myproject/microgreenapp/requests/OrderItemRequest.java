package com.myproject.microgreenapp.requests;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderItemRequest {
	
	private int p_id;
	@Min(value = 1, message = "Quantity must be at least 1")
	private int quantity;
}
