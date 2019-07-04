package com.chillax.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chillax.dto.User;

public interface IUserDao {
	
	public User queryByPrimaryKey(Integer id);
	
	public List<User> queryUserByBatch(Map<String,Object> params);
	
	public void insertUser(User user);
	
	public void insertUserByBatch(List<User> list);
	
	public void deleteByPrimaryKey(Integer id);
	
	public void delteUserByBatch(Map<String,Object> params);
	
	public void updateByPrimaryKey(Integer id);

	public List<User> getAllUser();
	
	public User login(@Param("name") String name,@Param("password") String password);
	
}