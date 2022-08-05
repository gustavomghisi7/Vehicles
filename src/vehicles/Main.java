package vehicles;

import vehicles.utility.ConnectionDatabase;

public class Main {

	public static void main(String[] args) {
		testConnection();
	}
	
	static void testConnection() {
		if(ConnectionDatabase.toConnect() != null) {
			System.out.println("Connection made successfully");
		}
	}

}
