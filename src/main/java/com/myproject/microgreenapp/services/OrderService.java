package com.myproject.microgreenapp.services;

import com.myproject.microgreenapp.entities.Order;
import com.myproject.microgreenapp.requests.OrderRequest;

public interface OrderService {
	
	Order placeOrder(OrderRequest orderRequest);

}
