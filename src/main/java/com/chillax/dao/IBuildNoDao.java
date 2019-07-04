package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface IBuildNoDao {

	public List<BuildNo> getBuildNo(@Param("communityId")int communityId,@Param("houseNum")int houseNum);	
	
	public BuildNo getBuildingById(@Param("id")int id);	
	
	public BuildNo getBuildId(@Param("communityId")int communityId,@Param("houseNum")int houseNum,@Param("no")String no);	
	
	public void saveBuildNo(@Param("buildNo")BuildNo buildNo);
		
}