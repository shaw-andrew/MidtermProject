package com.skilldistillery.cmms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EquipmentType {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String model;
	
	private String manufacturer;
	
	private int year;

	public EquipmentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipmentType(int id, String name, String model, String manufacturer, int year) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "EquipmentType [id=" + id + ", name=" + name + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", year=" + year + "]";
	}
	
	
	
}
