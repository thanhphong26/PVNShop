package com.pvnshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pvnshop.connection.DBConnection;
import com.pvnshop.dao.IUserDAO;
import com.pvnshop.models.UserModel;

public class UserDAOImpl implements IUserDAO{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<UserModel> getAllUser() {
		List<UserModel> listUser=new ArrayList<UserModel>();
		String sql="select * from user";
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				UserModel user=new UserModel();
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setIsAdmin(rs.getByte(6));
				user.setPassword(rs.getString(7));
				listUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	@Override
	public void insert(UserModel user) {
		String sql="insert into user values(?,?,?,?,?,?)";
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(UserModel user) {
		String sql="update user set name = ?, phone =?, email=?, addr=? where userName = ?";
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(5, user.getUsername());
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	public static void main(String[] args) {
		
	}
	
	@Override
	public void delete(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getOneUser(String username) {
		String sql="select * from user where userName=?";
		UserModel user=new UserModel();
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setIsAdmin(rs.getByte(6));
				user.setPassword(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserModel login(String username, String password) {
		String sql="select * from user where userName=? and password=?";
		UserModel user=new UserModel();
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setIsAdmin(rs.getByte(6));
				user.setPassword(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean checkExistUserEmail(String email) {
		String sql="select * from user where email=?";
		List<UserModel> listUser=new ArrayList<UserModel>();
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			while(rs.next()) {
				UserModel user=new UserModel();
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setIsAdmin(rs.getByte(6));
				user.setPassword(rs.getString(7));
				listUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!listUser.isEmpty()) {
			return true;
		}
		return false;
	}
	@Override
	public void registerUser(UserModel user) {
		String sql="insert into user(userName, name, phone, email, addr, password) values(?,?,?,?,?,?)";
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql="select * from user where userName=?";
		List<UserModel> listUser=new ArrayList<UserModel>();
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				UserModel user=new UserModel();
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setIsAdmin(rs.getByte(6));
				user.setPassword(rs.getString(7));
				listUser.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!listUser.isEmpty()) {
			return true;
		}
		return false;
	}

}
