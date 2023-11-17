package com.pvnshop.service.impl;
import java.util.List;

import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.impl.ProductDAOImpl;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;


public class ProductServiceImpl implements IProductService {
	
	private static IProductDAO pDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findTop3() {
		return pDAO.findTop3();
	}
	@Override
	public List<ProductModel> findRateTop3() {
		return pDAO.findRateTop3();
	}
	public ProductModel findByID(int id) 
	{
		return pDAO.findByID(id);
	}
	@Override
	public int CountProductByCate(int cateId) {
		return pDAO.CountProductByCate(cateId);
	}
	@Override
	public List<ProductModel> findall() {
		return pDAO.findAll();
	}
}
