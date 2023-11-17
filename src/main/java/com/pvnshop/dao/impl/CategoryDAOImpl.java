package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.ICategoryDAO;
import com.pvnshop.models.CategoryModel;

public class CategoryDAOImpl implements ICategoryDAO{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from category";
		List<CategoryModel> listCate = new ArrayList<CategoryModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				CategoryModel model = new CategoryModel();
				model.setCateID(rs.getInt(1));
				model.setCateName(rs.getString(2));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCate;
	}

}
