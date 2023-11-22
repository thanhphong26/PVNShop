package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IOrderDetailDAO;
import com.pvnshop.models.OrderDetailModel;
import com.pvnshop.models.OrderModel;

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

	@Override
	public List<OrderDetailModel> findAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM order_detail";
		List<OrderDetailModel> l = new ArrayList<OrderDetailModel>();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			OrderDetailModel model = new OrderDetailModel();
			model.setOrderID(rs.getInt(1));
			model.setProductID(rs.getInt(2));
			model.setQuantity(rs.getInt(3));
			l.add(model);
		}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
