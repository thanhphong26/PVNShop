package com.pvnshop.controller.web;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductDAO {
	List<ProductModel> findAll();
	
	List<ProductModel> findByID(int id);


}
