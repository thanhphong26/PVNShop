package com.pvnshop.dao;

import java.sql.Date;
import java.util.List;

import com.pvnshop.models.DiscountModel;

public interface IDiscountDAO {
	List<DiscountModel> findEnabel(Date date);
	DiscountModel findById(int id);
}
