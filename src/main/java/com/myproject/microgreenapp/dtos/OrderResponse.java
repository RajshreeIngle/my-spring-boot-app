package com.myproject.microgreenapp.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.myproject.microgreenapp.entities.OrderItem;

import lombok.Data;

@Data
public class OrderResponse {
	private long order_id;
	private LocalDateTime order_Date;
	private String status;
    private double total_Amount;
    private List<OrderItemResponse> items = new ArrayList<>();
}
