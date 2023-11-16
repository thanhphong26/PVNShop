package com.pvnshop.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IOrderDAO;
import com.pvnshop.models.OrderModel;

public class OrderDAOImpl implements IOrderDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<OrderModel> findAll() {
		String query = "SELECT * FROM `order`;";
		List<OrderModel> l = new ArrayList<OrderModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				Date time = rs.getDate(2);
				int total = rs.getInt(3);
				int state = rs.getInt(4);
				String note = rs.getString(5);
				String payment = rs.getString(6);
				String user_name = rs.getString(7);
				int disc = rs.getInt(8);
				String ship = rs.getString(9);
				int shipCost = rs.getInt(10);

				OrderModel model = new OrderModel(id, time, total, state, note, payment, user_name, disc, ship,
						shipCost);
				l.add(model);
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public int sum() {
		String query = "SELECT SUM(price) as n\r\n" + "FROM order_detail d JOIN product p\r\n"
				+ "ON d.product_id = p.productId";
		int l = 0;
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				l = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public void add(OrderModel model) {
		boolean bool = model.getDiscount_id() == null;
		String query;
		if (!bool)
			query = "insert into `order` values(null,?,?,?,?,?,?,?,?,?)";
		else
			query = "insert into `order` values(null,?,?,?,?,?,?,null,?,?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			if (!bool) {
				ps.setDate(1, model.getTime());
				ps.setInt(2, model.getTotal());
				ps.setInt(3, model.getState());
				ps.setString(4, model.getNote());
				ps.setString(5, model.getPayment_method());
				ps.setString(6, model.getUser_name());
				ps.setInt(7, model.getDiscount_id());
				ps.setString(8, model.getShipping_method());
				ps.setInt(9, model.getShip_cost());
			} else {
				ps.setDate(1, model.getTime());
				ps.setInt(2, model.getTotal());
				ps.setInt(3, model.getState());
				ps.setString(4, model.getNote());
				ps.setString(5, model.getPayment_method());
				ps.setString(6, model.getUser_name());
				ps.setString(7, model.getShipping_method());
				ps.setInt(8, model.getShip_cost());
			}
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int maxID() {
		String query = "select MAX(orderId) from `order`";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				return res.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 0;

	}
}
