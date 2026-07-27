package com.myproject.microgreenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.microgreenapp.entities.Product;

public interface MyProductRepository extends JpaRepository<Product, Integer> {

}
