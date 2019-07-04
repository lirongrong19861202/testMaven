package com.chillax.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.IApartmentTypeDao;
import com.chillax.dao.ICommunityDao;
import com.chillax.dao.ICommunityStatusDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.ICommunityService;
import com.chillax.service.ICommunityStatusService;
import com.chillax.service.IUserService;

@Service("communityStatusService")
public class CommunityStatusServiceImpl implements ICommunityStatusService {
	@Resource
	private ICommunityStatusDao communityStatusDao;

	@Override
	public List<CommunityStatus> getCommunityStatusList() {
		List<CommunityStatus> list = communityStatusDao.getCommunityStatusList();
		return list;
	}
	
	@Override
	public CommunityStatus getStatusById(int id) {
		CommunityStatus status = communityStatusDao.getStatusById(id);
		return status;
	}

	@Override
	public CommunityStatus getStatusByName(String name) {
		CommunityStatus status = communityStatusDao.getStatusByName(name);
		return status;
	}
}
