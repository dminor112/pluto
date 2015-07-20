package com.pluto.service;

import com.pluto.models.User;

public interface UserService {

	User getUser(String userId);

	public void addUser(User user);
}
