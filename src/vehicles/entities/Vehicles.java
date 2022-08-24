package vehicles.entities;

public class Vehicles {

	private int id;
	private String color;
	private String vehicleBrand;
	private String vehicleLicensePlate;
	
	
	public Vehicles() {
		
	}

	public Vehicles(String color, String vehicleBrand, String vehicleLicensePlate) {
		this.color = color;
		this.vehicleBrand = vehicleBrand;
		this.vehicleLicensePlate = vehicleLicensePlate;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleLicensePlate() {
		return vehicleLicensePlate;
	}

	public void setVehicleLicensePlate(String vehicleLicensePlate) {
		this.vehicleLicensePlate = vehicleLicensePlate;
	}
	

	@Override
	public String toString() {
		return "Vehicles [id: " + id + ", color: " + color + ", vehicleBrand: " + vehicleBrand + ", vehicleLicensePlate: "
				+ vehicleLicensePlate + "]";
	}
	
}
