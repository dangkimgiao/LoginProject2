package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	static String hostName = "localhost";//mặc định

	static String dbName = "LoginDB";//tên database
	static String Username = "root";//mặc định
	static String Password = "";//mặc định
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		 
	     Connection conn = DriverManager.getConnection(connectionURL, Username, Password);
	     return conn;
	}
}
