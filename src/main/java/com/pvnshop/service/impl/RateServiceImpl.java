package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IRateDAO;
import com.pvnshop.dao.impl.RateDAOImpl;
import com.pvnshop.models.RateModel;
import com.pvnshop.service.IRateService;

public class RateServiceImpl implements IRateService {
	private static IRateDAO ra = new RateDAOImpl();
	@Override
	public List<RateModel> ratetop3() {
		// TODO Auto-generated method stub
		return ra.ratetop3();
	}
	@Override
	public List<RateModel> findById(int proId) {
		// TODO Auto-generated method stub
		return ra.findById(proId);
	}
	@Override
	public int countAll(int proId) {
		// TODO Auto-generated method stub
		return ra.countAll(proId);
	}
	@Override
	public void insert(RateModel model) {
		ra.insert(model);
		
	}

}
