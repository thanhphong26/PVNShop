package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.OrderModel;

public interface IOrderService {
	List <OrderModel> findAll();
	int sum();
}
