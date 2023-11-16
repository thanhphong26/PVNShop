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

}
