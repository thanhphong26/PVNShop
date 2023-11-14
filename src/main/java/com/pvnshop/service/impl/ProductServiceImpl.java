package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.impl.ProductDAOImpl;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;



public class ProductServiceImpl implements IProductService{
	IProductDAO pDAO = new ProductDAOImpl();
	public ProductModel findByID(int id) 
	{
		return pDAO.findByID(id);
	}
	public List<ProductModel> findall() {
		return pDAO.findAll();
	}

}
