package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductDAO {
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
	public void InsertProduct(ProductModel model);
	public void DeleteProduct(int productID);
	public void UpdateProduct(ProductModel model);
	int countProduct();
	List<ProductModel> pagingProduct(int index);
}
