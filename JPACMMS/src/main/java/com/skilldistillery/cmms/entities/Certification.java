package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@ManyToMany
	@JoinTable (name = "certification_has_staff", 
				joinColumns = @JoinColumn (name = "certification_id"),
				inverseJoinColumns = @JoinColumn (name = "staff_id"))
	private List<Staff> staff;
	
	
	@ManyToMany 
	@JoinTable (name = "card_has_certification", 
		joinColumns = @JoinColumn (name = "certification_id"),
		inverseJoinColumns = @JoinColumn (name = "maintenance_requirement_card_id"))
	private List<MaintenanceRequirementCard> cards;
	
	
	public Certification() {}

	public Certification(int id, String name, String description) {
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

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<MaintenanceRequirementCard> getCards() {
		return cards;
	}

	public void setCards(List<MaintenanceRequirementCard> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Certification [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
