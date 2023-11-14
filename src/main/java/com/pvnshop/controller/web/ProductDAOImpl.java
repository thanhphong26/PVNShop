package com.pvnshop.controller.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO{
	public ProductModel findbyID(int id) {
		String sql = "SELECT * FROM cnpm.cart where product_id = ? ";
		ProductModel listByID = new ProductModel();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listByID.setProductID(rs.getInt(1));
				listByID.setProductName(rs.getString(2));
				listByID.setVersion(rs.getString(3));
				listByID.setDescription(rs.getString(4));
				listByID.setPrice(rs.getInt(5));
				listByID.setColor(rs.getString(6));
				listByID.setSize(rs.getString(7));
				listByID.setInventory(rs.getInt(8));
				listByID.setImage(rs.getString(9));
				listByID.setCateID(rs.getInt(10));
				listByID.setManuID(rs.getInt(11));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listByID;
	}
	public ProductModel findAll() {
		String sql = "SELECT * FROM cnpm.cart";
		ProductModel list = new ProductModel();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.setProductID(rs.getInt(1));
				list.setProductName(rs.getString(2));
				list.setVersion(rs.getString(3));
				list.setDescription(rs.getString(4));
				list.setPrice(rs.getInt(5));
				list.setColor(rs.getString(6));
				list.setSize(rs.getString(7));
				list.setInventory(rs.getInt(8));
				list.setImage(rs.getString(9));
				list.setCateID(rs.getInt(10));
				list.setManuID(rs.getInt(11));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
