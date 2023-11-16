package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.ICartDAO;
import com.pvnshop.models.CartModel;

public class CartDAOImpl implements ICartDAO{

	public List<CartModel> findByUser(String user) {
		List<CartModel> list = new ArrayList<CartModel>();
		String query = "select * from cart where user_name = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				CartModel model = new CartModel();
				model.setUsername(res.getString(1));
				model.setProductID(res.getInt(2));
				model.setQuantity(res.getInt(3));
				list.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete(String user, int id) {
		String query = "delete from cart where product_id = ? and user_name = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String user, int id, int quantity) {
		String query = "update cart set quantity=? where user_name=? and product_id=?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setString(2, user);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(String user) {
		String query = "delete from cart where user_name = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
