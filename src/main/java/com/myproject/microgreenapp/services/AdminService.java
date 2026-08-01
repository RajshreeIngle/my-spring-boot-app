package com.myproject.microgreenapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.dtos.AdminDto;
import com.myproject.microgreenapp.entities.Admin;
import com.myproject.microgreenapp.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public Admin addNewAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public Admin getAdminById(long adminId) {
		return adminRepository.findById(adminId).orElse(null);
	}
	
	

}
