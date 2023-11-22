package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.OrderDetailModel;
import com.pvnshop.models.OrderModel;

public interface IOrderDetailDAO {
	void add(OrderDetailModel model);

	List<OrderDetailModel> findAll();
}
