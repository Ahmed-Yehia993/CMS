package com.tie.service;

import com.tie.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
