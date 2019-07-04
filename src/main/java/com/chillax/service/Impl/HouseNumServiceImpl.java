package com.chillax.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.IApartmentTypeDao;
import com.chillax.dao.IBuildNoDao;
import com.chillax.dao.ICommunityDao;
import com.chillax.dao.IHouseNumDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.HouseNum;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.IBuildNoService;
import com.chillax.service.ICommunityService;
import com.chillax.service.IHouseNumService;
import com.chillax.service.IUserService;

@Service("houseNumService")
public class HouseNumServiceImpl implements IHouseNumService {
	@Resource
	private IHouseNumDao houseNumDao;

	@Override
	public List<HouseNum> getHouseNum(int communityId) {
		List<HouseNum> houseNum = houseNumDao.getHouseNum(communityId);
		return houseNum;
	}

	@Override
	public HouseNum getHouseNumById(int id) {
		HouseNum num = houseNumDao.getHouseNumById(id);
		return num;
	}

	@Override
	public HouseNum getHouseNumByCommunityAndNum(int communityId, String house_num) {
		HouseNum houseNum = houseNumDao.getHouseNumByCommunityAndNum(communityId,house_num);
		return houseNum;
	}

	@Override
	public void saveHouseNum(HouseNum houseNum) {
		houseNumDao.saveHouseNum(houseNum);
	}
}
