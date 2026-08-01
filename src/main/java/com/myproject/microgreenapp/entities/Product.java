package com.myproject.microgreenapp.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="product")
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int p_id;
	private String p_name;
	private String p_description;
	private float p_price;
	private String p_category;
	private int p_stock;
	
	@OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = new ArrayList<>();

}
