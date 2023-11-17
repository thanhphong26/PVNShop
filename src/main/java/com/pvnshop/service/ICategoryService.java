package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
