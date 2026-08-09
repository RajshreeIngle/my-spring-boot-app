package com.myproject.microgreenapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public Admin updateAdminInfo(long adminId, Admin admin) {
		Admin previousAdmin =adminRepository.findById(adminId).orElse(null);
		if(previousAdmin != null && admin.getAdminId() == adminId) {
			adminRepository.save(admin);
		}else if(previousAdmin != null && admin.getAdminId() != adminId){
			admin.setAdminId(adminId);
			adminRepository.save(admin);
		}else if(previousAdmin == null) {
			return null;
		}
		return admin;
	}

	public boolean deleteAdmin(long adminId) {
		Admin admin = adminRepository.findById(adminId).orElse(null);
		if(admin != null) {
			adminRepository.delete(admin);
			return true;
		}
		return false;
		 		
	}
	
	

}
