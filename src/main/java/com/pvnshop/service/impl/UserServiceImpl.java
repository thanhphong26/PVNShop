package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IUserDAO;
import com.pvnshop.dao.impl.UserDAOImpl;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDAO userDAO=new UserDAOImpl();
	@Override
	public List<UserModel> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
	}

	@Override
	public void update(UserModel user) {
		userDAO.update(user);
		
	}

	@Override
	public void delete(UserModel user) {
		userDAO.delete(user);
	}

	@Override
	public UserModel getOneUser(String username) {
		return userDAO.getOneUser(username);
	}
	@Override
	public UserModel login(String username, String password) {
		UserModel user=userDAO.getOneUser(username);
		if(user!=null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	@Override
	public boolean checkExistUserEmail(String email) {
		return userDAO.checkExistUserEmail(email);
	}
	@Override
	public boolean registerUser(String username, String name, String phone, String email, String address, String password) {
		if(userDAO.checkExistUserEmail(email)) {
			return false;
		}
		if(userDAO.checkExistUsername(username)) {
			return false;
		}
		userDAO.registerUser(new UserModel(username, name, phone, email, address, password));
		return true;
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUserEmail(username);
	}
}
