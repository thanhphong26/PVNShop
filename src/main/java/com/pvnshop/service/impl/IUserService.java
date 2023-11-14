package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.models.UserModel;

public interface IUserService {
	List<UserModel> getAllUser();
	void insert(UserModel user);
	void update(UserModel user);
	void delete(UserModel user);
	UserModel getOneUser(String username);
	UserModel login(String username, String password);
	boolean checkExistUserEmail(String email);
	void registerUser(UserModel user);
}
