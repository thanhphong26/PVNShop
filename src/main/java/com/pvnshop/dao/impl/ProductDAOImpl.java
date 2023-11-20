package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IProductDAO;
import com.pvnshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	Connection conn;
	static IProductDAO pro = new ProductDAOImpl();

	@Override
	public List<ProductModel> findAll() {
		String sql = "Select * from product";
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
	@Override
	public List<ProductModel> findProductByCate(String cateId) {
		String sql = "Select * from product where cate_id = ?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cateId);
			ResultSet rs = ps.executeQuery();
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
	@Override
	public int CountProductByCate(int cateId) {
		String sql = "Select count(productId) from product where cate_id = ?";
		int count = 0;
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				count = rs.getInt(1); 
			}
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
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
			conn = new DBConnection().getConnection();
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
			e.printStackTrace();
		}
		return l;
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
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public ProductModel getLastestProduct() {
		String sql="select * from product order by productId desc limit 1";
		ProductModel product =new ProductModel();
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				product.setProductID(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setVersion(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setColor(rs.getString(6));
				product.setSize(rs.getString(7));
				product.setInventory(rs.getInt(8));
				product.setImage(rs.getString(9));
				product.setCateID(rs.getInt(10));
				product.setManuID(rs.getInt(11));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
