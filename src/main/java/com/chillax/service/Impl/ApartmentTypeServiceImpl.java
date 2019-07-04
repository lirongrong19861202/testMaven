package com.chillax.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.IApartmentTypeDao;
import com.chillax.dao.ICommunityDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.ICommunityService;
import com.chillax.service.IUserService;

@Service("apartmentTypeService")
public class ApartmentTypeServiceImpl implements IApartmentTypeService {
	@Resource
	private IApartmentTypeDao apartmentTypeDao;

	@Override
	public List<ApartmentType> getApartmentTypeList() {
		List<ApartmentType> list = apartmentTypeDao.getApartmentTypeList();
		return list;
	}
	
	@Override
	public ApartmentType getTypeById(int id){
		ApartmentType type = apartmentTypeDao.getTypeById(id);
		return type;
	}

	@Override
	public ApartmentType getTypeByName(String name) {
		ApartmentType type = apartmentTypeDao.getTypeByName(name);
		return type;
	}
}
