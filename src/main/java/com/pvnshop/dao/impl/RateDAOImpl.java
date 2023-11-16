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

}
