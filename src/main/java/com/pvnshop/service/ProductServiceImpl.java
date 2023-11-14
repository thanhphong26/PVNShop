package com.pvnshop.service;

import java.util.List;

import com.pvnshop.controller.web.IProductDAO;
import com.pvnshop.controller.web.ProductDAOImpl;
import com.pvnshop.models.ProductModel;



public class ProductServiceImpl implements IProductService{
	IProductDAO pDAO = new ProductDAOImpl();
	public List<ProductModel> findByID(int id) 
	{
		return pDAO.findByID(id);
	}
	public List<ProductModel> findall() {
		return pDAO.findAll();
	}

	
}
