package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.impl.ProductDAOImpl;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;

public class ProductServiceImpl implements IProductService{
	IProductDAO pro = new ProductDAOImpl();
	
	@Override
	public List<ProductModel> findAll() {
		return pro.findAll();
	}

	@Override
	public List<ProductModel> findProductByCate(int cateId) {
		return pro.findProductByCate(cateId);
	}

	@Override
	public int CountProductByCate(int cateId) {
		return pro.CountProductByCate(cateId);
	}

}
