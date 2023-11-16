package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductDAO {
	public List<ProductModel> findTop3();
	public List<ProductModel> findRateTop3();
	List<ProductModel> findAll();
	List<ProductModel> findTop();
	ProductModel findByID(int id);
 	List<ProductModel> findProductByCate(int cateId);
	int CountProductByCate(int cateId);
}
