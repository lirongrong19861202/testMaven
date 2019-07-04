package com.chillax.service;

import java.util.List;
import java.util.Map;

import com.chillax.dto.BuildNo;
import com.chillax.dto.HouseInfo;

public interface IHouseInfoService {

	public List<Map<String,Object>> getHouseBasicInfo(Integer community,Integer  houseNum,Integer building,Integer apartmentType,Integer communityStatus,String locate);
	
	public List<Map<String,Object>> findBuild(int fyXqCode,int fyLh,int fyDh,int fyCh,int fyFh);
	
	public void saveHouseInfo(HouseInfo houseInfo);
	
	public void deleteHouseById(int id);

}
