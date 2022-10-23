package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "equipment_type")
@Entity
public class EquipmentType {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String model;
	
	private String manufacturer;
	
	private int year;
	
	@OneToMany(mappedBy = "equipmentType")
	private List<Equipment> equipment;
	
	@OneToMany(mappedBy = "equipmentType")
	private List<MaintenanceRequirementCard> mrc;

	public EquipmentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipmentType(int id, String name, String model, String manufacturer, int year, List<Equipment> equipment,
			List<MaintenanceRequirementCard> mrc) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
		this.equipment = equipment;
		this.mrc = mrc;
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

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public List<MaintenanceRequirementCard> getMrc() {
		return mrc;
	}

	public void setMrc(List<MaintenanceRequirementCard> mrc) {
		this.mrc = mrc;
	}

	@Override
	public String toString() {
		return "EquipmentType [id=" + id + ", name=" + name + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", year=" + year + ", equipment=" + equipment + ", mrc=" + mrc + "]";
	}

	
	
}
