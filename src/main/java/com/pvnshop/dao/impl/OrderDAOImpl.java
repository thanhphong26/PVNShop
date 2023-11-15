package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IOrderDAO;
import com.pvnshop.models.OrderModel;
import com.pvnshop.models.ProductModel;

public class OrderDAOImpl implements IOrderDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<OrderModel> findAll() {
		String query ="SELECT * FROM `order`;";
		List<OrderModel> l = new ArrayList<OrderModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				Date time = rs.getDate(2);
				int  total = rs.getInt(3);
				int state = rs.getInt(4);
				String note = rs.getString(5);
				String payment =  rs.getString(6);
				String user_name =  rs.getString(7);
				int disc =  rs.getInt(8);
				String ship =  rs.getString(9);
				int shipCost =  rs.getInt(10);
				
				OrderModel model = new OrderModel(id, time, total,state, note, payment, user_name, disc, ship, shipCost); 
				l.add(model);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
