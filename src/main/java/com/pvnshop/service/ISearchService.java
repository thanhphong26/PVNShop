package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.ProductModel;

public interface ISearchService {
	List<ProductModel> searchByName(String txtsearch);

}
