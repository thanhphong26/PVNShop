package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IOrderDetailDAO;
import com.pvnshop.dao.impl.OrderDetailDAOImpl;
import com.pvnshop.models.OrderDetailModel;
import com.pvnshop.models.OrderModel;
import com.pvnshop.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService{
	private static IOrderDetailDAO odDAO = new OrderDetailDAOImpl();
	@Override
	public void add(OrderDetailModel model) {
		odDAO.add(model);
	}
	@Override
	public List<OrderDetailModel> findAll() {
		// TODO Auto-generated method stub
		return odDAO.findAll();
	}
	
}
