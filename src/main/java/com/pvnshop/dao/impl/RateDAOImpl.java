package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IRateDAO;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;

public class RateDAOImpl implements IRateDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<RateModel> ratetop3() {
		String query ="SELECT r.context, u.name\r\n"
				+ "FROM rate r JOIN user u ON r.user_name = u.userName\r\n"
				+ "LIMIT 3;";
		List<RateModel> l = new ArrayList<RateModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String cont = rs.getString(2);
				String name = rs.getString(1);
				
				RateModel model = new RateModel(cont, name); 
				l.add(model);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public int countAll(int proId) {
		String sql = "SELECT count(*) FROM rate where product_id = " + proId;
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<RateModel> findById(int proId) {
		String sql = "SELECT * FROM rate where product_id = " + proId;
		List<RateModel> list = new ArrayList<RateModel>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) 
			{
				RateModel model = new RateModel();
				model.setRateID(rs.getInt(1));
				model.setContext(rs.getString(2));
				model.setProductID(rs.getInt(3));
				model.setStart(rs.getInt(4));
				model.setUsername(rs.getString(5));
				list.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(RateModel model) {
		String sql="INSERT INTO rate (context, product_id, star, user_name) VALUES (?, ?, ?, ?)";
		try {
			Connection conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, model.getContext());
			ps.setInt(2, model.getProductID());
			ps.setInt(3, model.getStart());
			ps.setString(4, model.getUsername());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
