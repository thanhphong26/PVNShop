package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.OrderDetailModel;
import com.pvnshop.models.OrderModel;

public interface IOrderDetailService {
	void add(OrderDetailModel model);
	List<OrderDetailModel> findAll();
}
