package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface IApartmentTypeDao {

	public List<ApartmentType> getApartmentTypeList();	
	
	public ApartmentType getTypeById(@Param("id")int id);

	public ApartmentType getTypeByName(@Param("name")String name);
	
}