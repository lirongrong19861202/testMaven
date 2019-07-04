package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface ICommunityDao {

	public List<Community> getAllCommunity();	
	
	public Community getCommunityById(@Param("id")int id);
	
	public List<Community> getCommunityByName(@Param("name")String name);	
	
	public void saveCommunity(@Param("community")Community community);
}