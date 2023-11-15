package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IProductDAO;
import com.pvnshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	Connection conn;
	static IProductDAO pro = new ProductDAOImpl();

	@Override
	public List<ProductModel> findAll() {
		String sql = "Select * from product";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				ProductModel model = new ProductModel();

				model.setProductID(rs.getInt("productId"));
				model.setProductName(rs.getString("productName"));
				model.setVersion(rs.getString("version"));
				model.setDescription(rs.getString("description"));
				model.setPrice(rs.getInt("price"));
				model.setColor(rs.getString("color"));
				model.setSize(rs.getString("size"));
				model.setInventory(rs.getInt("inventory"));
				model.setImage(rs.getString("image"));
				model.setCateID(rs.getInt("cate_id"));
				model.setManuID(rs.getInt("manu_id"));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductModel> findProductByCate(int cateId) {
		String sql = "Select * from product where cate_id = ?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel model = new ProductModel();

				model.setProductID(rs.getInt("productId"));
				model.setProductName(rs.getString("productName"));
				model.setVersion(rs.getString("version"));
				model.setDescription(rs.getString("description"));
				model.setPrice(rs.getInt("price"));
				model.setColor(rs.getString("color"));
				model.setSize(rs.getString("size"));
				model.setInventory(rs.getInt("inventory"));
				model.setImage(rs.getString("image"));
				model.setCateID(rs.getInt("cate_id"));
				model.setManuID(rs.getInt("manu_id"));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public static void main(String[] args)
	{
		//System.out.println(pro.CountProductByCate(1));
	}
	@Override
	public int CountProductByCate(int cateId) {
		String sql = "Select count(productId) from product where cate_id = ?";
		int count = 0;
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				count = rs.getInt(1); 
			}
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
