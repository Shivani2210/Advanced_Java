package Day_12;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleSelectQueryExampleMain {
	public static void main(String[] args) {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/shivani?useSSL=false";
		String Username = "root";
		String Password = "Shivani@123";
		try {
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");
			Connection dbconnection = DriverManager.getConnection(URL, Username, Password);
			System.out.println("Connected to database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException  e1) {
			e1.printStackTrace();
		}	
	}

}
