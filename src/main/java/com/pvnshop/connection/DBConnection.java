package com.pvnshop.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
	private static String DB_URL="jdbc:mysql://localhost:3306/pvnshop_nhom6";
	private static String USER_NAME="root";
	private static String PASSWORD="15242635";
	private static Connection conn;
	
	public static Connection getConnection() throws IOException {
		conn =null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
			
		}
		return (conn);
	}
}
