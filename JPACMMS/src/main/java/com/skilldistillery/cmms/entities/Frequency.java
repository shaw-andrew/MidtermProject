package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Frequency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;
	
	@OneToMany (mappedBy = "frequency")
	private List<MaintenanceRequirementCard> cards;
	
	

	public Frequency() {
		super();
	}

	public Frequency(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Frequency [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
