package com.myproject.microgreenapp.services;

import com.myproject.microgreenapp.dtos.OrderResponse;
import com.myproject.microgreenapp.entities.Order;
import com.myproject.microgreenapp.requests.OrderRequest;

public interface OrderService {
	
	OrderResponse placeOrder(OrderRequest orderRequest);
	
	OrderResponse getOrderById(long order_id);

}
