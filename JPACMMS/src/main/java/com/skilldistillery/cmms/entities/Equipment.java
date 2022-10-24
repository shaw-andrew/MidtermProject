package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="equipment_type_id")
	private EquipmentType equipmentType;
	
	
	
	private String name;
	
	private String description;
	
	@Column (name ="image_url")
	private String imageURL;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToMany (mappedBy = "equipment")
	private List<MaintenanceItem> task;

	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipment(int id, EquipmentType equipmentType, String name, String description, String imageURL,
			Location location, List<MaintenanceItem> task) {
		super();
		this.id = id;
		this.equipmentType = equipmentType;
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.location = location;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<MaintenanceItem> getTask() {
		return task;
	}

	public void setTask(List<MaintenanceItem> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return name + ": " + description;
	}

	
	
	
}
