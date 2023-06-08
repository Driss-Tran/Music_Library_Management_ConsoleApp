package database;

import java.sql.*;

public class JDBCConnection {
	// Create connection from Database.
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3000/music_app";
			String name = "root";
			String pass = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,name,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
}
