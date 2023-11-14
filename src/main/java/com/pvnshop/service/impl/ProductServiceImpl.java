package com.pvnshop.service.impl;


import java.util.List;

import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.productDao;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;


public class ProductServiceImpl implements IProductService {
	
	private static IProductDAO cat = new productDao();
	@Override
	public List<ProductModel> findTop3() {
		// TODO Auto-generated method stub
		return cat.findTop3();
	}
	@Override
	public List<ProductModel> findRateTop3() {
		// TODO Auto-generated method stub
		return cat.findRateTop3();
	}

}
