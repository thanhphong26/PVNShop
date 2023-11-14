package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductDAO {
	List<ProductModel> findAll();
	ProductModel findByID(int id);
}
