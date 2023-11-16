package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IOrderDetailDAO;
import com.pvnshop.models.OrderDetailModel;

public class OrderDetailDAOImpl implements IOrderDetailDAO{

	@Override
	public void add(OrderDetailModel model) {
		String query = "insert into order_detail values(?,?,?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, model.getOrderID());
			ps.setInt(2, model.getProductID());
			ps.setInt(3, model.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
