package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.User;

public interface ICommunityStatusDao {

	public List<CommunityStatus> getCommunityStatusList();	
	
	public CommunityStatus getStatusById(@Param("id")int id);	
	
	public CommunityStatus getStatusByName(@Param("name")String name);
	
}