package com.chillax.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.ICommunityService;
import com.chillax.service.ICommunityStatusService;
import com.chillax.service.IUserService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IApartmentTypeService apartmentTypeService;
	@Resource
	private ICommunityStatusService communityStatusService;
	
	@RequestMapping("/apartmentType")
	@ResponseBody
	public Map apartmentTypeList(){
		List<ApartmentType> apartmentTypeList = apartmentTypeService.getApartmentTypeList();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", apartmentTypeList);
		return result;
	}
	
	@RequestMapping("/communityStatus")
	@ResponseBody
	public Map communityStatusList(){
		List<CommunityStatus> communityStatusList = communityStatusService.getCommunityStatusList();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", communityStatusList);
		return result;
	}
	
}