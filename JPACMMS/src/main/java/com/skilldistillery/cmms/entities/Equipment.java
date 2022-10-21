package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="equipment_type_id")
	private int equipmentTypeId;
	
	@Column(name="location_id")
	private int locationId;
	
	private String name;
	
	private String description;
	
	private String imageURL;

	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipment(int id, int equipmentTypeId, int locationId, String name, String description, String imageURL) {
		super();
		this.id = id;
		this.equipmentTypeId = equipmentTypeId;
		this.locationId = locationId;
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEquipmentTypeId() {
		return equipmentTypeId;
	}

	public void setEquipmentTypeId(int equipmentTypeId) {
		this.equipmentTypeId = equipmentTypeId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", equipmentTypeId=" + equipmentTypeId + ", locationId=" + locationId + ", name="
				+ name + ", description=" + description + ", imageURL=" + imageURL + "]";
	}
	
	
}
