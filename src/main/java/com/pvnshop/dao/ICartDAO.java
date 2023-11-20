package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.CartModel;

public interface ICartDAO {
	List<CartModel> findByUser(String user);
	void delete(String user,int id);
	void delete(String user);
	void update(String user, int id, int quantity);
	void insert (CartModel cart);
}
