package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface IProductDAO {
	public List<ProductModel> findTop3();
}
