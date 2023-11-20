package com.pvnshop.service;

import java.util.List;

import com.pvnshop.models.RateModel;

public interface IRateService {
	List<RateModel> ratetop3();
	List<RateModel> findById(int proId);
	int countAll(int proId);
	void insert(RateModel model);
}
