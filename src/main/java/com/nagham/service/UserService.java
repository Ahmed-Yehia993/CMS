package com.nagham.service;

import com.nagham.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
