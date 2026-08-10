package com.myproject.microgreenapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.dtos.OrderResponse;
import com.myproject.microgreenapp.entities.Order;
import com.myproject.microgreenapp.requests.OrderRequest;
import com.myproject.microgreenapp.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder( @Valid @RequestBody OrderRequest orderRequest){
		OrderResponse orderResponse = orderService.placeOrder(orderRequest);
		return ResponseEntity.ok(orderResponse);	
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderById(
	        @PathVariable long orderId) {

	    return ResponseEntity.ok(
	            orderService.getOrderById(orderId)
	    );
	}

}
