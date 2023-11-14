package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.CartModel;

public interface ICartDAO {
	List<CartModel> findByUser(String user);
}
