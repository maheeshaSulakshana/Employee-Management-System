package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/Company";
			String user = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			return con;
		}
		catch (Exception ex) {
			System.out.println("Error from MySqlConnector:- " +ex.getMessage());
			return null;
		}
	}
	
}
