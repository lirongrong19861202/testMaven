package com.chillax.service;

import java.util.List;

import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface ICommunityService {

	public List<Community> getAllCommunity();
	
	public Community getCommunityById(int id);
	
	public List<Community> getCommunityByName(String name);
	
	public void saveCommunity(Community community);
}
