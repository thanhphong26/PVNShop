package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.CartModel;

public interface ICartService {
	List<CartModel> findByUser(String user);
	void delete(int id);
}
