package com.chillax.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.BuildNo;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.HouseInfo;
import com.chillax.dto.HouseNum;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.IBuildNoService;
import com.chillax.service.ICommunityService;
import com.chillax.service.ICommunityStatusService;
import com.chillax.service.IHouseInfoService;
import com.chillax.service.IHouseNumService;
import com.chillax.service.IUserService;
import com.chillax.util.ImportExcelTool;
import com.chillax.vo.HouseInfoVO;

@Controller
@RequestMapping("/house")
public class HouseListController {
	@Resource
	private ICommunityService communityService;
	@Resource
	private IBuildNoService buildNoService;
	@Resource
	private IHouseInfoService houseInfoService;
	@Resource
	private IApartmentTypeService apartmentTypeService;
	@Resource
	private ICommunityStatusService communityStatusService;
	@Resource
	private IHouseNumService houseNumService;
	
	@RequestMapping("/communityList")
	@ResponseBody
	public Map communityList(){
		List<Community> communityList = communityService.getAllCommunity();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", communityList);
		return result;
	}
	
	//
	@RequestMapping("/houseNum")
	@ResponseBody
	public Map houseNum(Integer communityId){
		List<HouseNum> houseNum = houseNumService.getHouseNum(communityId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", houseNum);
		return result;
	}
	
	@RequestMapping("/buildNo")
	@ResponseBody
	public Map buildNo(Integer communityId,Integer houseNum){
		List<BuildNo> communityList = buildNoService.getBuildNo(communityId,houseNum);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", communityList);
		return result;
	}
	
	@RequestMapping("/basicInfo")
	@ResponseBody
	public List<Map<String,Object>> getHouseBasicInfo(Integer  community,Integer  houseNum,Integer  building,Integer  apartmentType,Integer communityStatus,String locate){
		List<Map<String,Object>> houseList = houseInfoService.getHouseBasicInfo(community,houseNum,building,apartmentType,communityStatus,locate);
		List<Map<String,Object>> houseResult = new ArrayList<Map<String,Object>>();
		for(int i=0;i<houseList.size();i++){
			Map<String,Object> result = new HashMap<String,Object>();
			int community1 = (int) houseList.get(i).get("community");
			int house_num = (int) houseList.get(i).get("house_num");
			String houseNo = houseList.get(i).get("no").toString();
			String communityLocate = houseList.get(i).get("communityLocate").toString();
			String floor_num = houseList.get(i).get("floor_num").toString();
			int apartmentType1 = (int)houseList.get(i).get("apartment_type");
			int communityStatus1 = (int)houseList.get(i).get("community_status");
			int building1 = (int)houseList.get(i).get("building");
			String num = houseList.get(i).get("num").toString();//房号
			String locate1 = houseList.get(i).get("locate").toString();
			BigDecimal area = (BigDecimal) houseList.get(i).get("house_area");
			BigDecimal calculate_area = (BigDecimal) houseList.get(i).get("calculate_area");
			String lease_nuture = houseList.get(i).get("lease_nuture").toString();
			String structure = houseList.get(i).get("structure").toString();
			String communityName = houseList.get(i).get("communityName").toString();
			String id = houseList.get(i).get("id").toString();
			String no = "";
			String typeName = "";
			String status2 = "";
				
			if(building1!=0){
				BuildNo build = buildNoService.getBuildingById(building1);
				if(build!=null){
					no = build.getNo();
				}
			}
			if(apartmentType1!=0){
				ApartmentType type = apartmentTypeService.getTypeById(apartmentType1);
				if(type!=null){
					typeName = type.getType_name();
				}
			}
			if(communityStatus1!=0){
				CommunityStatus status = communityStatusService.getStatusById(communityStatus1);
				if(status!=null){
					status2 = status.getName();
				}
			}
			if(house_num!=0){
				HouseNum house = houseNumService.getHouseNumById(house_num);
				if(house!=null){
					no = house.getNum();
				}
			}
			String house_No = communityName+no+"号楼"+floor_num+"-"+num;
			result.put("id", id);//房子的id
			result.put("locate", communityLocate);//位置
			result.put("houseNo", house_No);//房源
			result.put("area", area);//面积
			result.put("calculate_area", calculate_area);//建筑面积
			result.put("typeName", typeName);//户型
			result.put("sturcture", structure);//建筑结构
			result.put("nature", lease_nuture);//租赁性质
			result.put("status", status2);//租赁性质
			houseResult.add(result);
		}
		return houseResult;
	}
	@RequestMapping("/checkFyFhIsExists")
	@ResponseBody
	public Map checkFyFhIsExists(Integer fyXqCode,Integer fyLh,Integer fyDh,Integer fyCh,Integer fyFh){
		List<Map<String,Object>> communityList = houseInfoService.findBuild(fyXqCode,fyLh,fyDh,fyCh,fyFh);
		Map<String,Object> result = new HashMap<String,Object>();
		//没找到该房源
		if(communityList.size()<=0){
			result.put("result", "false");
		}else{
			result.put("result", "true");
		}
		return result;
	}
	@RequestMapping("/saveHouseInfo")
	@ResponseBody
	public void saveHouseInfo(@RequestBody HouseInfo houseInfo){
		if(houseInfo!=null){
			 houseInfoService.saveHouseInfo(houseInfo);
		}
	}
	//批量删除
	@RequestMapping("/deleteHouseList")
	@ResponseBody
	public void deleteHouseList(String allIDCheck){
		if(allIDCheck!=null && !allIDCheck.equals("")){
			String[] idList = allIDCheck.split(",");
			for(int i=0;i<idList.length;i++){
				int id = Integer.parseInt(idList[i]);
				houseInfoService.deleteHouseById(id);
			}
		}
	}
	//导入excel文件组装成HouseInfoVO  显示在table中
	@RequestMapping("/createHouseInfo")
	@ResponseBody
	public Map<String,Object> createHouseInfo(MultipartFile  file){
		Map<String,Object> map = new HashMap<String,Object>();
		List<HouseInfoVO> houseList = new ArrayList<HouseInfoVO>();
		if(file.getSize()!=0){
			HouseInfoVO houseBasicInfo = new HouseInfoVO();
			try {
				List<String[]> house = ImportExcelTool.readExcel(file);
				for(int i=0;i<house.size();i++){
					String locate = house.get(i)[0];//小区位置
					String source = house.get(i)[1];//房源
					String[] string = source.split("[0-9]");//[威尼斯水城, 号楼, -]
					String[] string1 = source.split("-");//[威尼斯水城4号楼4, 808]
					int index = string1[0].indexOf(string[1]);
					String house_num =  string1[0].substring(string[0].length(), index);//楼号
					String building = string1[0].substring(index+2, string1[0].length());//栋号
					String num = string1[1];//房号
					int num1 = Integer.parseInt(num);
					String string2 = string1[0];
					String communityName = string[0];//小区名字
					String house_area = house.get(i)[2];//房源面积
					Float house_area1 = Float.valueOf(house_area);
					String calculate_area = house.get(i)[3];//计算面积
					Float calculate_area1 = Float.valueOf(calculate_area);
					String apartment_type = house.get(i)[4];//户型
					ApartmentType type = apartmentTypeService.getTypeByName(apartment_type);
					if(type==null){
						map.put("info", "户型字段填写错误");
					}
					String structure = house.get(i)[5];//建筑结构
					String lease_nuture = house.get(i)[6];//租赁性质
					String community_status = house.get(i)[7];//状态
					CommunityStatus communityStatus = communityStatusService.getStatusByName(community_status);
					if(communityStatus==null){
						map.put("info", "状态字段填写错误");
					}
					//查询小区id---没有就保存
					List<Community> communityList = communityService.getCommunityByName(communityName);
					int communityId = 0;
					if(communityList.size()>0){
						communityId = communityList.get(0).getId();//小区id
					}else{
						Community community = new Community();
						community.setName(communityName);
						community.setLocate(locate);
						community.setStatus("1");
						communityService.saveCommunity(community);
					}
					//查询楼号id
					List<Community> communityList1 = communityService.getCommunityByName(communityName);
					HouseNum houseNum = houseNumService.getHouseNumByCommunityAndNum(communityList1.get(0).getId(),house_num);
					int houseNumId = 0;
					if(houseNum!=null){
						houseNumId = houseNum.getId();
					}else{
						if(communityList1.size()>0){
							HouseNum houseNum1 = new HouseNum();
							houseNum1.setCommunity_id(communityList1.get(0).getId());
							houseNum1.setNum(house_num);
							houseNumService.saveHouseNum(houseNum1);
						}
					}
					//查询小区所在楼号的栋数id
					HouseNum houseNum1 = houseNumService.getHouseNumByCommunityAndNum(communityList1.get(0).getId(),house_num);
					BuildNo build = buildNoService.getBuildId(communityList1.get(0).getId(),houseNum1.getId(),building);
					int buildNo = 0;
					if(build!=null){
						buildNo = build.getId();
					}else{
						BuildNo buildNo1 = new BuildNo();
						buildNo1.setCommunity_id(communityList1.get(0).getId());
						buildNo1.setHouse_num(houseNum1.getId());
						buildNo1.setNo(building);
						buildNoService.saveBuildNo(buildNo1);
					}
					//查找房源是否已经保存
					String floor_num = num.substring(0, 1);
					int floor_num1 = Integer.parseInt(floor_num);
					BuildNo build1 = buildNoService.getBuildId(communityList1.get(0).getId(),houseNum1.getId(),building);
					List<Map<String, Object>> houseInfo = houseInfoService.findBuild(communityList1.get(0).getId(), houseNum1.getId(), build1.getId(), floor_num1, num1);
					if(houseInfo.size()<=0){
						HouseInfo info = new HouseInfo();
						info.setCommunity(communityList1.get(0).getId());
						info.setHouse_num(houseNum1.getId());
						info.setBuilding(build1.getId());
						info.setFloor_num(floor_num);
						info.setNum(num);
						info.setHouse_area(house_area1);
						info.setCalculate_area(calculate_area1);
						info.setApartment_type(type.getId());
						info.setStructure(structure);
						info.setLocate(house_num+"-"+num);
						info.setPosition("");
						info.setLease_nuture(lease_nuture);
						info.setCommunity_status(communityStatus.getId());
						houseInfoService.saveHouseInfo(info);
					}
					houseBasicInfo.setApartmentType(apartment_type);
					houseBasicInfo.setCalculateArea(calculate_area);
					houseBasicInfo.setCommunityName(communityName);
					houseBasicInfo.setHouseArea(house_area);
					houseBasicInfo.setLeaseNature(lease_nuture);
					houseBasicInfo.setLocation(locate);
					houseBasicInfo.setStatus(community_status);
					houseBasicInfo.setStructure(structure);
					houseList.add(houseBasicInfo);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		map.put("house", houseList);
        return map;// 返回列表显示	
	}
}