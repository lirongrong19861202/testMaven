package com.chillax.service;

import java.util.List;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface IApartmentTypeService {

	public List<ApartmentType> getApartmentTypeList();
	
	public ApartmentType getTypeById(int id);

	public ApartmentType getTypeByName(String name);
}
