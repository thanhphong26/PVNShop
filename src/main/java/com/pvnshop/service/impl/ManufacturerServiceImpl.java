package com.pvnshop.service.impl;

import java.util.List;

import com.pvnshop.dao.IManufacturerDAO;
import com.pvnshop.dao.impl.ManufacturerDAOImpl;
import com.pvnshop.models.ManufacturerModel;
import com.pvnshop.service.IManufacturerService;

public class ManufacturerServiceImpl implements IManufacturerService{
	IManufacturerDAO manu = new ManufacturerDAOImpl();
	@Override
	public List<ManufacturerModel> findAll() {
		return manu.findALL();
	}

}
