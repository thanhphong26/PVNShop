package com.pvnshop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static String DB_URL="jdbc:mysql://localhost:3306/cnpm";
	private static String USER_NAME="root";
	private static String PASSWORD="15242635";
	private static Connection conn;
	
	public static Connection getConnection() {
		conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn=(Connection)DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		}catch(SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return conn;
	}
	public static void main(String[] args) {
		try {
			Connection c=getConnection();
			System.out.println(DBConnection.getConnection());
			if(c==null) {
				System.out.println("Something went wrong");
			}else {
				System.out.println("Ok");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
