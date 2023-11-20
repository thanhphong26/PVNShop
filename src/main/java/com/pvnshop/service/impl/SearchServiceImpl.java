package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.ISearchDAO;
import com.pvnshop.dao.impl.SearchDAOImpl;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.ISearchService;

public class SearchServiceImpl implements ISearchService{

	ISearchDAO sDAO = new SearchDAOImpl();
	@Override
	public List<ProductModel> searchByName(String txtsearch) {
		
		return sDAO.searchByName(txtsearch) ;
	}

}
