package com.myproject.microgreenapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.entities.Order;
import com.myproject.microgreenapp.requests.OrderRequest;
import com.myproject.microgreenapp.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest){
		Order order = orderService.placeOrder(orderRequest);
		return ResponseEntity.ok(order);	
	}

}
