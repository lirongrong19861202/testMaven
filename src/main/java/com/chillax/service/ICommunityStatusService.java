package com.chillax.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.User;

public interface ICommunityStatusService {

	public List<CommunityStatus> getCommunityStatusList();	
	
	public CommunityStatus getStatusById(int id);
	
	public CommunityStatus getStatusByName(String name);
}