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
		String query ="WITH a AS(\r\n"
				+ "SELECT product_id, sum(o.quantity) as tong\r\n"
				+ "FROM order_detail o \r\n"
				+ "RIGHT JOIN product p ON o.product_id = p.productId\r\n"
				+ "GROUP BY product_id\r\n"
				+ "ORDER BY tong desc\r\n"
				+ "LIMIT 3)\r\n"
				+ "SELECT p.*\r\n"
				+ "FROM product p JOIN a\r\n"
				+ "ON p.productId = a.product_id";
		List<ProductModel> l = new ArrayList<ProductModel>();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String  ver = rs.getString(3);
				String des = rs.getString(4);
				int pr = rs.getInt(5);
				String color =  rs.getString(6);
				String size =  rs.getString(7);
				int inve =  rs.getInt(8);
				String image =  rs.getString(9);
				int caid =  rs.getInt(10);
				int maid =  rs.getInt(11);
				ProductModel model = new ProductModel(id, name, ver,des, pr, color, size, inve, image, caid, maid); 
				l.add(model);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public List<ProductModel> findRateTop3() {
		String query ="WITH a AS(\r\n"
				+ "	SELECT product_id, avg(r.star) as tong\r\n"
				+ "	FROM rate r \r\n"
				+ "	RIGHT JOIN product p ON r.product_id = p.productId\r\n"
				+ "	GROUP BY product_id\r\n"
				+ "	ORDER BY tong desc\r\n"
				+ "	LIMIT 3)\r\n"
				+ "	SELECT p.*\r\n"
				+ "	FROM product p JOIN a\r\n"
				+ "	ON p.productId = a.product_id";
		List<ProductModel> l = new ArrayList<ProductModel>();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String  ver = rs.getString(3);
				String des = rs.getString(4);
				int pr = rs.getInt(5);
				String color =  rs.getString(6);
				String size =  rs.getString(7);
				int inve =  rs.getInt(8);
				String image =  rs.getString(9);
				int caid =  rs.getInt(10);
				int maid =  rs.getInt(11);
				ProductModel model = new ProductModel(id, name, ver,des, pr, color, size, inve, image, caid, maid); 
				l.add(model);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
}