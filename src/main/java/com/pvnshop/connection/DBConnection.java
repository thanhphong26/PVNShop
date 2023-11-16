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
	private static String DB_URL="jdbc:mysql://localhost:3306/cnpm";
	private static String USER_NAME="root";
<<<<<<< Updated upstream
	private static String PASSWORD="Nguyen123.";
=======
	private static String PASSWORD="3011";
>>>>>>> Stashed changes
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
	public static void main(String[] args) {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product");
			while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) );
			}
			conn.close(); 
			} catch (Exception ex) {
			ex.printStackTrace();
			}
	}
}
