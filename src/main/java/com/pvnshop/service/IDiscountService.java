package com.pvnshop.service;

import java.sql.Date;
import java.util.List;

import com.pvnshop.models.DiscountModel;

public interface IDiscountService {
	List<DiscountModel> findEnabel(Date date);
	DiscountModel findById(int id);
}
