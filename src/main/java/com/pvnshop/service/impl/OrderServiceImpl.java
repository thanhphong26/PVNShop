package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IOrderDAO;
import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.productDao;
import com.pvnshop.dao.impl.OrderDAOImpl;
import com.pvnshop.models.OrderModel;
import com.pvnshop.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	private static IOrderDAO oDAO = new OrderDAOImpl();
	@Override
	public List<OrderModel> findAll() {
		// TODO Auto-generated method stub
		return oDAO.findAll();
	}
	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return oDAO.sum();
	}

}
