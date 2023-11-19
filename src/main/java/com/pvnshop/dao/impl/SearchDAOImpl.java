package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.ISearchDAO;
import com.pvnshop.models.ProductModel;

public class SearchDAOImpl implements ISearchDAO{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<ProductModel> searchByName(String txtsearch) {
		String sql = "Select * from product \r\n"
				+ "where productName like '%"+txtsearch+"%'";
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
		
}
