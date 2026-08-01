package com.myproject.microgreenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.microgreenapp.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
