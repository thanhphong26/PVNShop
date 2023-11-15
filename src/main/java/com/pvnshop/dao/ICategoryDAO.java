package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll ();
}
