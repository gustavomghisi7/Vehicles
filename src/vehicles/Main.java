package vehicles;

import vehicles.dao.DaoVehicles;
import vehicles.entities.Vehicles;
import vehicles.utility.ConnectionDatabase;

public class Main {

	public static void main(String[] args) {
		deleteVehicle();
	}
	
	static void testConnection() {
		if(ConnectionDatabase.toConnect() != null) {
			System.out.println("Connection made successfully");
		}
	}
	
	static void enterData() {
		Vehicles vh = new Vehicles("Blue", "Volkswagen", "CBA-4321");			
		DaoVehicles vh1 = new DaoVehicles();
			
		if (vh1.create(vh)) {
			System.out.println("Vehicle registered successfully");
		}
	}
	
	static void consultAll() {
		DaoVehicles vh1 = new DaoVehicles();
		System.out.println(vh1.readAll());
	}
	
	static void consultOneVehicle() {
		DaoVehicles vh1 = new DaoVehicles();
		System.out.println(vh1.read(1));
	}
	
	static void updateVehicle() {
		DaoVehicles vh1 = new DaoVehicles();
		Vehicles vehicle = vh1.read(1);
		System.out.println(vehicle);
		
		vehicle.setColor("Yellow");
		vehicle.setVehicleBrand("Volkswagen");
		vehicle.setVehicleLicensePlate("ZXY-9876");
		if(vh1.update(vehicle)) {
			System.out.println("Vehicle successfully changed!");
			System.out.println(vehicle);
		}
	}
	
	static void deleteVehicle() {
		DaoVehicles vh1 = new DaoVehicles();
		Vehicles vehicle = vh1.read(1);
		System.out.println(vehicle);
		vh1.delete(1);;
	}
	

}
