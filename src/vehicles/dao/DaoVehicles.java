package vehicles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vehicles.entities.Vehicles;
import vehicles.interfaceGenerics.ICrudInterfaceGenerics;
import vehicles.utility.ConnectionDatabase;

public class DaoVehicles implements ICrudInterfaceGenerics<Vehicles>  {

	@Override
	public boolean create(Vehicles obj) {
		String sql = "INSERT INTO vehicles(color, vehicleBrand, vehicleLicensePlate) VALUES (?, ?, ?)";
		
		Connection isConnected = ConnectionDatabase.toConnect();
		
		try {
			PreparedStatement stm = isConnected.prepareStatement(sql);
			stm.setString(1, obj.getColor());
			stm.setString(2, obj.getVehicleBrand());
			stm.setString(3, obj.getVehicleLicensePlate());
			stm.execute();		
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		} finally {
			ConnectionDatabase.closeConnection();
		}
		
		return true;
	}

	@Override
	public Vehicles read(int id) {
		Vehicles vehicle = new Vehicles();
		String sql = "SELECT * FROM vehicles WHERE id = " + id;
		
		Connection isConnected = ConnectionDatabase.toConnect();
		
		try {
			PreparedStatement stm = isConnected.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				vehicle.setId(rs.getInt("id"));
				vehicle.setColor(rs.getString("color"));
				vehicle.setVehicleBrand(rs.getString("vehicleBrand"));
				vehicle.setVehicleLicensePlate(rs.getString("vehicleLicensePlate"));
			}
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		} finally {
			ConnectionDatabase.closeConnection();
		}
		
		return vehicle;
	}

	@Override
	public boolean update(Vehicles obj) {
		String sql = "update vehicles set color = ?, vehicleBrand = ?, vehicleLicensePlate = ? where id = ?";
		
		Connection isConnected = ConnectionDatabase.toConnect();
		
		try {
			PreparedStatement stm = isConnected.prepareStatement(sql);
			stm.setString(1, obj.getColor());
			stm.setString(2, obj.getVehicleBrand());
			stm.setString(3, obj.getVehicleLicensePlate());
			stm.setInt(4, obj.getId());
			stm.execute();
			
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		} finally {
			ConnectionDatabase.closeConnection();
		}
		
		return true;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM vehicles WHERE id = " + id;
		
		Connection isConnected = ConnectionDatabase.toConnect();
		try {
			PreparedStatement stm = isConnected.prepareStatement(sql);
			stm.execute();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		} finally {
			ConnectionDatabase.closeConnection();
		}
		
	}

	@Override
	public List<Vehicles> readAll() {
		List<Vehicles> vehicles = new ArrayList<>();
		String sql = "SELECT * FROM vehicles";
		
		Connection isConnected = ConnectionDatabase.toConnect();
		
		try {
			PreparedStatement stm = isConnected.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vehicles vehicle = new Vehicles();
				vehicle.setId(rs.getInt("id"));
				vehicle.setColor(rs.getString("color"));
				vehicle.setVehicleBrand(rs.getString("vehicleBrand"));
				vehicle.setVehicleLicensePlate(rs.getString("vehicleLicensePlate"));
				vehicles.add(vehicle);
			}
			
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		} finally {
			ConnectionDatabase.closeConnection();
		}
		
		return vehicles;
	}
	
}
