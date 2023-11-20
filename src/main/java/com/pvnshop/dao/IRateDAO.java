package com.pvnshop.dao;

import java.util.List;

import com.pvnshop.models.RateModel;

public interface IRateDAO {
	List<RateModel> ratetop3();
	List<RateModel> findById(int proId);
	int countAll(int proId);
	void insert(RateModel model);
}
