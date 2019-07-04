package com.chillax.service;

import java.util.List;

import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.User;

public interface IBuildNoService {

	public List<BuildNo> getBuildNo(int communityId,int houseNum);
	
	public BuildNo getBuildingById(int id);
	
	public BuildNo getBuildId(int communityId,int houseNum,String no);
	
	public void saveBuildNo(BuildNo buildNo);
}
