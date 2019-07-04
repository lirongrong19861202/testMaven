package com.chillax.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.IApartmentTypeDao;
import com.chillax.dao.IBuildNoDao;
import com.chillax.dao.ICommunityDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.IBuildNoService;
import com.chillax.service.ICommunityService;
import com.chillax.service.IUserService;

@Service("buildNoService")
public class BuildNoServiceImpl implements IBuildNoService {
	@Resource
	private IBuildNoDao buildNoDao;

	@Override
	public List<BuildNo> getBuildNo(int communityId,int houseNum) {
		List<BuildNo> list = buildNoDao.getBuildNo(communityId,houseNum);
		return list;
	}

	@Override
	public BuildNo getBuildingById(int id) {
		BuildNo list = buildNoDao.getBuildingById(id);
		return list;
	}

	@Override
	public BuildNo getBuildId(int communityId, int houseNum, String no) {
		BuildNo list = buildNoDao.getBuildId(communityId,houseNum,no);
		return list;
	}

	@Override
	public void saveBuildNo(BuildNo buildNo) {
		buildNoDao.saveBuildNo(buildNo);
	}
}
