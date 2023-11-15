package com.pvnshop.service;

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
	boolean checkExistUsername(String username);
	boolean registerUser(String username, String name, String phone, String email, String address, String password);
}
