package com.myproject.microgreenapp.requests;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
	
	@NotNull(message = "Customer ID is required")
	private long customerId;
	
	@NotEmpty(message = "Order must contain at least one product")
	private List<OrderItemRequest> items;

}
