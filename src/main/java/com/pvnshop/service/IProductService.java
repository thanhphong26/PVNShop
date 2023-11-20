package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductService {
	public List<ProductModel> findTop3();
	public List<ProductModel> findRateTop3();
	List<ProductModel> findAll();
	List<ProductModel> findTop();
	ProductModel findByID(int id);
	List<ProductModel> findProductByCate(String cateId);
	int CountProductByCate(int cateId);
	List<ProductModel> sortPriceLowtoHigh();
	List<ProductModel> sortPriceHightoLow();
	ProductModel getLastestProduct();
}
