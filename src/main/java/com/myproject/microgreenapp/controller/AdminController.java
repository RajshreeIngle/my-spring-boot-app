package com.myproject.microgreenapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.dtos.AdminDto;
import com.myproject.microgreenapp.entities.Admin;
import com.myproject.microgreenapp.mappers.AdminMapper;
import com.myproject.microgreenapp.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminMapper adminMapper;
	
	@GetMapping("/getall")
	public List<AdminDto> getAllAdmins() {
		List<Admin> admins = adminService.getAllAdmins();
		List<AdminDto> adminDtos = admins.stream().map(admin -> adminMapper.adminToAdminDto(admin)).toList();
		return adminDtos;	
	}
	
	@GetMapping("/getadminbyid/{adminId}")
	public AdminDto getAdminById(@PathVariable long adminId) {
		Admin admin = adminService.getAdminById(adminId);
		return adminMapper.adminToAdminDto(admin);	
	}
	
	@PostMapping("/addnewadmin")
	public Admin addNewAdmin(@Valid @RequestBody Admin admin) {
		return adminService.addNewAdmin(admin);	
	}
	
	@PutMapping("/updateadminInfo/{adminId}")
	public ResponseEntity<AdminDto> updateAdminInfo(@PathVariable long adminId, @RequestBody Admin admin){
		
		return null;
	}
	

}
