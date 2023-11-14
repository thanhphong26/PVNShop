package com.pvnshop.controller.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.models.ProductModel;


public class ProductDAOImpl implements IProductDAO{
	public List<ProductModel> findAll() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM cnpm.user";
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
	public List<ProductModel> findByID(int id){
			List<ProductModel> list = new ArrayList<ProductModel>();
			String sql = "SELECT * FROM cnpm.user where product_id=?";
			try {
				new DBConnection();
				Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) 
				{
					ProductModel listByID = new ProductModel();
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
					list.add(listByID);
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			}
	
}

