package com.pvnshop.service.impl;

import java.sql.Date;
import java.util.List;

import com.pvnshop.dao.IDiscountDAO;
import com.pvnshop.dao.impl.DiscountDAOImpl;
import com.pvnshop.models.DiscountModel;
import com.pvnshop.service.IDiscountService;

public class DiscountServiceImpl implements IDiscountService{
	private static IDiscountDAO dDao = new DiscountDAOImpl();
	@Override
	public List<DiscountModel> findEnabel(Date date) {
		// TODO Auto-generated method stub
		return dDao.findEnabel(date);
	}
	@Override
	public DiscountModel findById(int id) {
		return dDao.findById(id);
	}

}
