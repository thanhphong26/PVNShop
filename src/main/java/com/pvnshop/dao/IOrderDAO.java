package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.OrderModel;

public interface IOrderDAO {
	List <OrderModel> findAll();
}