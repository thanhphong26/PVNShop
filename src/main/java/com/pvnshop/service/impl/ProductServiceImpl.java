package com.pvnshop.service.impl;


import java.util.List;

import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;


public class ProductServiceImpl implements IProductService {
	
	private static IProductService cat = new ProductServiceImpl();
	@Override
	public List<ProductModel> findTop3() {
		// TODO Auto-generated method stub
		return cat.findTop3();
	}

}
