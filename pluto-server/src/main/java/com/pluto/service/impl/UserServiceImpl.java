package com.pluto.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pluto.models.User;
import com.pluto.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	Map<String, User> userMap = new HashMap<String, User>();
	
	public User getUser(String userId){
		return userMap.get(userId);
	}
	
	public void addUser(User user){
		userMap.put(user.getId(), user);
	}
}
