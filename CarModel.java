package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id ;
	private String model;
	private String make;
	private String production_year;
	private String engine;
	private String fuel;
	
	public CarModel( String model, String make, String production_year, String engine, String fuel) {
		super();
		
		this.model = model;
		this.make = make;
		this.production_year = production_year;
		this.engine = engine;
		this.fuel = fuel;
	}

public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getProduction_year() {
		return production_year;
	}
	public void setProduction_year(String production_year) {
		this.production_year = production_year;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
}
