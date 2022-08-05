package vehicles.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
	
	public static Connection isConnected = null;
	
	public static Connection toConnect() {
		String url = "jdbc:postgresql://localhost:5432/JDBC";
		String user = "postgres";
		String password = "admin";
		
		try {
			isConnected = DriverManager.getConnection(url, user, password);
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		
		return isConnected;
	}
	
	public static void closeConnection() {
		isConnected = null;
	}

}
