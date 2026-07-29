package com.myproject.microgreenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.microgreenapp.entities.Customer;

@Repository
public interface MyCustomerRepository extends JpaRepository<Customer, Long>{


}
