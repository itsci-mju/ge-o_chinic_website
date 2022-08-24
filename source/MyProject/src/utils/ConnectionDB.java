package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	String url= "jdbc:mysql://localhost:3306/projectt?characterEncoding=UTF-8";
	String uname= "root";
	String pwd= "1234";
	Connection con= null;
	
	public Connection getConnection() {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pwd);} 
		catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		} 
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return  con;
	}
	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
