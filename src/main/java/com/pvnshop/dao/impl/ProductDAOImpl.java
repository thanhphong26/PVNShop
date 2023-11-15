package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IProductDAO;
import com.pvnshop.models.ProductModel;


public class ProductDAOImpl implements IProductDAO{
	public List<ProductModel> findAll() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel listall = new ProductModel();
				listall.setProductID(rs.getInt(1));
				listall.setProductName(rs.getString(2));
				listall.setVersion(rs.getString(3));
				listall.setDescription(rs.getString(4));
				listall.setPrice(rs.getInt(5));
				listall.setColor(rs.getString(6));
				listall.setSize(rs.getString(7));
				listall.setInventory(rs.getInt(8));
				listall.setImage(rs.getString(9));
				listall.setCateID(rs.getInt(10));
				listall.setManuID(rs.getInt(11));
				list.add(listall);
			}	;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ProductModel findByID(int id){
			ProductModel model = new ProductModel();
			String sql = "SELECT * FROM product where productId=?";
			try {
				new DBConnection();
				Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) 
				{
					model.setProductID(rs.getInt(1));
					model.setProductName(rs.getString(2));
					model.setVersion(rs.getString(3));
					model.setDescription(rs.getString(4));
					model.setPrice(rs.getInt(5));
					model.setColor(rs.getString(6));
					model.setSize(rs.getString(7));
					model.setInventory(rs.getInt(8));
					model.setImage(rs.getString(9));
					model.setCateID(rs.getInt(10));
					model.setManuID(rs.getInt(11));
					return model;
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			}
	@Override
	public List<ProductModel> findTop3() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductModel> findRateTop3() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductModel> findTop() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

