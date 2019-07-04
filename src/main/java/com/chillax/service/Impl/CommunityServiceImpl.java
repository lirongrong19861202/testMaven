package com.chillax.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chillax.dao.ICommunityDao;
import com.chillax.dao.IUserDao;
import com.chillax.dto.Community;
import com.chillax.dto.User;
import com.chillax.service.ICommunityService;
import com.chillax.service.IUserService;

@Service("communityService")
public class CommunityServiceImpl implements ICommunityService {
	@Resource
	private ICommunityDao communityDao;

	public List<Community> getAllCommunity() {
		return communityDao.getAllCommunity();
	}
 
	public Community getCommunityById(int id){
		return communityDao.getCommunityById(id);
	}

	@Override
	public List<Community> getCommunityByName(String name) {
		return communityDao.getCommunityByName(name);
	}

	@Override
	public void saveCommunity(Community community) {
		communityDao.saveCommunity(community);
	}
}
