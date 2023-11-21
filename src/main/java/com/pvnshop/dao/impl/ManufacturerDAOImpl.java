package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IManufacturerDAO;
import com.pvnshop.models.ManufacturerModel;

public class ManufacturerDAOImpl implements IManufacturerDAO{

	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<ManufacturerModel> findALL() {
		String sql = "select * from manufacturer";
		List <ManufacturerModel> list = new ArrayList<ManufacturerModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) 
			{
				ManufacturerModel model = new ManufacturerModel();
				model.setManuID(rs.getInt(1));
				model.setManuName(rs.getString(2));
				model.setAddress(rs.getString(3));
				model.setEmail(rs.getString(4));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
