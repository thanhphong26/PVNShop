package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductService {
	List<ProductModel> findall();
	ProductModel findByID(int id);

}
