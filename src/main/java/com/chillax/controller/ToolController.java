package com.chillax.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chillax.dto.ApartmentType;
import com.chillax.dto.Community;
import com.chillax.dto.CommunityStatus;
import com.chillax.dto.User;
import com.chillax.service.IApartmentTypeService;
import com.chillax.service.ICommunityService;
import com.chillax.service.ICommunityStatusService;
import com.chillax.service.IUserService;
import com.chillax.util.ExportExcelTool;
import com.chillax.util.UtilClass;
import com.chillax.vo.HouseInfoVO;

@Controller
@RequestMapping("/tool")
public class ToolController {
	
	@RequestMapping("/exportHouse")
	@ResponseBody
	public Map<String,Object> exportHouse(@RequestBody List<HouseInfoVO> houseList,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		UtilClass util = new UtilClass();
		String path = util.loadPath();
		// 定义表的标题
        String title = "房屋信息一览表";
        //定义表的内容
        List<Object[]> dataList = new ArrayList<Object[]>();
        //定义表的列名
        String[] rowsName = new String[] { "位置", "房源", "房源面积", "计租面积", "户型", "建筑结构", "租赁性质", "状态" };
        for(int i=0;i<houseList.size();i++){
        	HouseInfoVO house = houseList.get(i);
        	Object[] objs = new Object[8];
        	objs[0]=house.getLocation();
        	objs[1]=house.getCommunityName();
        	objs[2]=house.getHouseArea();
        	objs[3]=house.getCalculateArea();
        	objs[4]=house.getApartmentType();
        	objs[5]=house.getStructure();
        	objs[6]=house.getLeaseNature();
        	objs[7]=house.getStatus();
        	dataList.add(objs);
        }
      //执行导出  
        ExportExcelTool.exportExcel(request,response,title, rowsName, dataList, "yyyy-MM-dd HH:mm:ss");
        map.put("house", houseList);
        return map;// 返回列表显示	
	}
}