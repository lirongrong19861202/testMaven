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

import com.chillax.dto.User;
import com.chillax.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/userList")
	public String userList(HttpServletRequest request,Model model){
		List<User> uList = userService.getAllUser();
		model.addAttribute("uList", uList);
		return "userList";
	}
	
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/addUserUI")
	public String addUserUI(){
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,Model model){
		User user = new User();
		user.setName(String.valueOf(request.getParameter("name")));
		user.setPassword(String.valueOf(request.getParameter("password")));
		user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));
		userService.addUser(user);
		return "redirect:/user/userList";
	}
	@RequestMapping(value="/login")
	@ResponseBody
	public String login(String name,String password){
		String result = "";
		User user = new User();
		user = userService.login(name,password);
		if(user!=null){
			result = "success";
		}else{
			result =  "fail";
		}
		return result;
	}
}