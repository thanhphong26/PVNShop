package com.pvnshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.models.ProductModel;


public class productDao implements IProductDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
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
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
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
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
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
	public List<ProductModel> findAll() {
		String query ="SELECT * FROM product";
		List<ProductModel> l = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
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
			return l;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public ProductModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductModel> findTop() {
		String query ="WITH a AS(\r\n"
				+ "	SELECT product_id, sum(o.quantity) as tong\r\n"
				+ "	FROM order_detail o \r\n"
				+ "	RIGHT JOIN product p ON o.product_id = p.productId\r\n"
				+ "	GROUP BY product_id\r\n"
				+ "	ORDER BY tong desc)\r\n"
				+ "	SELECT p.*\r\n"
				+ "	FROM product p JOIN a\r\n"
				+ "	ON p.productId = a.product_id;";
		List<ProductModel> l = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
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
