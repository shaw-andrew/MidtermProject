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
public class Tool {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
	@JoinTable (name = "card_has_tool", 
				joinColumns = @JoinColumn (name = "tool_id"),
				inverseJoinColumns = @JoinColumn (name = "maintenance_requirement_card_id"))
	private List<MaintenanceRequirementCard> cards;

	public Tool() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addMRC(MaintenanceRequirementCard mrc) {
		if (cards == null) {
			cards = new ArrayList<>();
		}
		if (!cards.contains(mrc)) {
			cards.add(mrc);
			mrc.addTool(this);
		}
	}

	public void removeMRC(MaintenanceRequirementCard mrc) {
		if (cards != null && cards.contains(mrc)) {
			cards.remove(mrc);
			mrc.removeTool(this);
		}
	}

	public Tool(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Tool [id=" + id + ", name=" + name + "]";
	}
	
	
}
