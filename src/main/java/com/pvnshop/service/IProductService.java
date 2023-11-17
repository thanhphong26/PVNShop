package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductService {
	public List<ProductModel> findTop3();
	public List<ProductModel> findRateTop3();
	List<ProductModel> findall();
	ProductModel findByID(int id);
	int CountProductByCate(int cateId);
}

