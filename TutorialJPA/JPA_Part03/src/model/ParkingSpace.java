package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class ParkingSpace {
	@Id
	@TableGenerator(name = "parking_gen")
	@GeneratedValue(generator = "parking_gen")
	private int id;
	private int flat;
	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlat() {
		return flat;
	}

	public void setFlat(int flat) {
		this.flat = flat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ParkingSpace(int flat, String location) {

		this.flat = flat;
		this.location = location;
	}

	public ParkingSpace() {
		super();
	}

}
