package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.CartModel;

public interface ICartService {
	List<CartModel> findByUser(String user);
	void delete(String user, int id);
	void delete(String user);
	void update(String user, int id, int quantity);
	void insert(CartModel cart);
}
