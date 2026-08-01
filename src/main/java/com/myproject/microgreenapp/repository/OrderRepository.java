package com.myproject.microgreenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.microgreenapp.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
