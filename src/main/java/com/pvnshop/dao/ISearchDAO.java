package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface ISearchDAO {
	List<ProductModel> searchByName(String txtsearch);
}
