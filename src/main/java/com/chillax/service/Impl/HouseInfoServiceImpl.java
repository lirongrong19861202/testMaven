package com.chillax.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.IApartmentTypeDao;
import com.chillax.dao.ICommunityDao;
import com.chillax.dao.IHouseInfoDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.HouseInfo;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.ICommunityService;
import com.chillax.service.IHouseInfoService;
import com.chillax.service.IUserService;

@Service("houseInfoService")
public class HouseInfoServiceImpl implements IHouseInfoService {
	@Resource
	private IHouseInfoDao houseInfoDao;

	@Override
	public List<Map<String,Object>> getHouseBasicInfo(Integer community,Integer  houseNum, Integer building, Integer apartmentType, Integer communityStatus,
			String locate) {
		List<Map<String,Object>> house = houseInfoDao.getHouseBasicInfo(community,houseNum, building, apartmentType, communityStatus, locate);
		return house;
	}
	
	@Override
	public List<Map<String,Object>> findBuild(int fyXqCode,int fyLh,int fyDh,int fyCh,int fyFh) {
		List<Map<String,Object>> list = houseInfoDao.findBuild(fyXqCode,fyLh,fyDh,fyCh,fyFh);
		return list;
	}
	
	@Override
	public void saveHouseInfo(HouseInfo houseInfo) {
		 houseInfoDao.saveHouseInfo(houseInfo);
	}
	
	@Override
	public void deleteHouseById(int id) {
		 houseInfoDao.deleteHouseById(id);
	}
}
