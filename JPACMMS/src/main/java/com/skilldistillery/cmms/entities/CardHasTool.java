package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CardHasTool {

	@Column(name="maintenance_requirement_card_id")
	private int maintenanceRequirementCardId;
	
	@Column(name="tool_id")
	private int toolId;

	public CardHasTool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardHasTool(int maintenanceRequirementCardId, int toolId) {
		super();
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
		this.toolId = toolId;
	}

	public int getMaintenanceRequirementCardId() {
		return maintenanceRequirementCardId;
	}

	public void setMaintenanceRequirementCardId(int maintenanceRequirementCardId) {
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	@Override
	public String toString() {
		return "CardHasTool [maintenanceRequirementCardId=" + maintenanceRequirementCardId + ", toolId=" + toolId + "]";
	}
	
	
}
