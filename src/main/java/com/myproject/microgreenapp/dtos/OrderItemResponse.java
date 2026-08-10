package com.myproject.microgreenapp.dtos;

import lombok.Data;

@Data
public class OrderItemResponse {
    private String productName;
    private int quantity;
    private double price;
    private double subtotal;

}
