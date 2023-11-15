package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCate(int cateId);
	int CountProductByCate(int cateId);
}
