package com.skilldistillery.cmms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Part {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private double cost;
	
	@Column(name="part_number")
	private int partNumber;
	
	@ManyToMany
	@JoinTable (name = "card_has_part", 
				joinColumns = @JoinColumn (name = "part_id"),
				inverseJoinColumns = @JoinColumn (name = "maintenance_requirement_card_id"))
	private List<MaintenanceRequirementCard> cards;
	

	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Part(int id, String description, double cost, int partNumber) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.partNumber = partNumber;
	}
	
	public void addMRC(MaintenanceRequirementCard mrc) {
		if (cards == null) {
			cards = new ArrayList<>();
		}
		if (!cards.contains(mrc)) {
			cards.add(mrc);
			mrc.addPart(this);
		}
	}

	public void removeMRC(MaintenanceRequirementCard mrc) {
		if (cards != null && cards.contains(mrc)) {
			cards.remove(mrc);
			mrc.removePart(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", description=" + description + ", cost=" + cost + ", partNumber=" + partNumber
				+ "]";
	}
	
	
	
}
