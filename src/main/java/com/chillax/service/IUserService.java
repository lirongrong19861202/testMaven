package com.chillax.service;

import java.util.List;

import com.chillax.dto.User;

public interface IUserService {
	
	public User getUserById(int userId);

	public void insertUser(User user);

	public void addUser(User user);

	public List<User> getAllUser();
	
	public User login(String name,String password);
}
