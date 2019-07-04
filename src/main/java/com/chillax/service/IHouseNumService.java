package com.chillax.service;

import java.util.List;

import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.HouseNum;
import com.chillax.dto.User;

public interface IHouseNumService {

	public List<HouseNum> getHouseNum(int communityId);
	
	public HouseNum getHouseNumById(int id);
	
	public HouseNum getHouseNumByCommunityAndNum(int communityId,String house_num);
	
	public void saveHouseNum(HouseNum houseNum);
}
