package com.myproject.microgreenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.microgreenapp.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
