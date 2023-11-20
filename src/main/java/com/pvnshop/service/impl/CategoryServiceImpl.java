package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.ICategoryDAO;
import com.pvnshop.dao.impl.CategoryDAOImpl;
import com.pvnshop.models.CategoryModel;
import com.pvnshop.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	ICategoryDAO cateDAO=new CategoryDAOImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDAO.findAll();
	}
	@Override
	public CategoryModel findById(int proId) {
		// TODO Auto-generated method stub
		return cateDAO.findById(proId);
	}

}
