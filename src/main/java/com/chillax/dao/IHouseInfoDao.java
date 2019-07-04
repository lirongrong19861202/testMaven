package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.HouseInfo;
import com.chillax.dto.User;

public interface IHouseInfoDao {

	public List<Map<String,Object>> getHouseBasicInfo(@Param("community")Integer community,@Param("houseNum")Integer houseNum,@Param("building")Integer building,
			@Param("apartmentType")Integer apartmentType,@Param("communityStatus")Integer communityStatus,@Param("locate")String locate);	
	
	public List<Map<String,Object>> findBuild(@Param("fyXqCode")int fyXqCode,@Param("fyLh")int fyLh,@Param("fyDh")int fyDh,@Param("fyCh")int fyCh,@Param("fyFh")int fyFh);
	
	public void saveHouseInfo(@Param("houseInfo")HouseInfo houseInfo);
	
	public void deleteHouseById(@Param("id")int id);
}