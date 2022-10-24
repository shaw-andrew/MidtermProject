package com.skilldistillery.cmms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Safety {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String category;

	private String description;
	
	@ManyToMany
	@JoinTable (name = "card_has_safety", 
				joinColumns = @JoinColumn (name = "safety_id"),
				inverseJoinColumns = @JoinColumn (name = "maintenance_requirement_card_id"))
	private List<MaintenanceRequirementCard> cards;

	public Safety() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Safety(int id, String category, String description) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
	}
	
	public void addMRC(MaintenanceRequirementCard mrc) {
		if (cards == null) {
			cards = new ArrayList<>();
		}
		if (!cards.contains(mrc)) {
			cards.add(mrc);
			mrc.addSafety(this);
		}
	}

	public void removeMRC(MaintenanceRequirementCard mrc) {
		if (cards != null && cards.contains(mrc)) {
			cards.remove(mrc);
			mrc.removeSafety(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Safety [id=" + id + ", category=" + category + ", description=" + description + "]";
	}

}
