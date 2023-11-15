package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.ICartDAO;
import com.pvnshop.dao.impl.CartDAOImpl;
import com.pvnshop.models.CartModel;
import com.pvnshop.service.ICartService;

public class CartServiceImpl implements ICartService{
	private static ICartDAO cartD = new CartDAOImpl();
	@Override
	public List<CartModel> findByUser(String user) {
		return cartD.findByUser(user);
	}
	@Override
	public void delete(int id) {
		cartD.delete(id);
	}

}