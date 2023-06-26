package Day_12;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	public static Connection BuildConnection() throws Exception{
		String URL = "jdbc:mysql://localhost:3306/shivani?useSSL=false";
		String Username = "root";
		String Password = "Shivani@123";
		Connection dbconnection = DriverManager.getConnection(URL, Username, Password);
		return dbconnection;
		
	}

}
