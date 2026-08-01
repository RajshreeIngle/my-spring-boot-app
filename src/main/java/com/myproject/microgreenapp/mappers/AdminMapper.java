package com.myproject.microgreenapp.mappers;

import org.mapstruct.Mapper;

import com.myproject.microgreenapp.dtos.AdminDto;
import com.myproject.microgreenapp.entities.Admin;

@Mapper(componentModel = "Spring")
public interface AdminMapper {
	
	AdminDto adminToAdminDto(Admin admin);

}
