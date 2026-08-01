package com.myproject.microgreenapp.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="orders")
@Entity
public class Order {
	@Id
	private long order_id;
	private LocalDateTime order_Date;
	private String status;
    private double total_Amount;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
	
}
