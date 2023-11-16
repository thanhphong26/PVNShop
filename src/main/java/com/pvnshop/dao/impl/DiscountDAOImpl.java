package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IDiscountDAO;
import com.pvnshop.models.DiscountModel;

public class DiscountDAOImpl implements IDiscountDAO{

	@Override
	public List<DiscountModel> findEnabel(Date date) {
		List<DiscountModel> list = new ArrayList<DiscountModel>();
		String query = "Select * from discount where dateEnd > ? and quantity > 0";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, date);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				DiscountModel model = new DiscountModel();
				model.setDiscountID(res.getInt(1));
				model.setPercent(res.getBigDecimal(2));
				model.setMinium(res.getInt(3));
				model.setMaximum(res.getInt(4));
				model.setDateStart(res.getDate(5));
				model.setDateEnd(res.getDate(6));
				model.setQuantity(res.getInt(7));
				list.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DiscountModel findById(int id) {
		DiscountModel model = new DiscountModel();
		String query = "select * from discount where discountId=?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				model.setDiscountID(res.getInt(1));
				model.setPercent(res.getBigDecimal(2));
				model.setMinium(res.getInt(3));
				model.setMaximum(res.getInt(4));
				model.setDateStart(res.getDate(5));
				model.setDateEnd(res.getDate(6));
				model.setQuantity(res.getInt(7));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
