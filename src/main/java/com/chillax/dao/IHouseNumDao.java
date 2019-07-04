package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.HouseNum;
import com.chillax.dto.User;

public interface IHouseNumDao {

	public List<HouseNum> getHouseNum(int communityId);	
	
	public HouseNum getHouseNumById(@Param("id")int id);
	
	public HouseNum getHouseNumByCommunityAndNum(@Param("communityId")int communityId,@Param("house_num")String house_num);
	
	public void saveHouseNum(@Param("houseNum")HouseNum houseNum);
}