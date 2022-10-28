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
	
	private String name;
	
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


	public Part(int id, String description, double cost, String name, int partNumber,
			List<MaintenanceRequirementCard> cards) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.name = name;
		this.partNumber = partNumber;
		this.cards = cards;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPartNumber() {
		return partNumber;
	}


	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}


	public List<MaintenanceRequirementCard> getCards() {
		return cards;
	}


	public void setCards(List<MaintenanceRequirementCard> cards) {
		this.cards = cards;
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


	@Override
	public String toString() {
		return  name + " Part Number: " + partNumber;
	}
	
}
