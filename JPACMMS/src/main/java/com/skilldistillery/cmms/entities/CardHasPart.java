package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CardHasPart {
	
	@Column(name="maintenance_requirement_card_id")
	private int maintenanceRequirementCardId;
	
	@Column(name="part_id")
	private int partId;

	public CardHasPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardHasPart(int maintenanceRequirementCardId, int partId) {
		super();
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
		this.partId = partId;
	}

	public int getMaintenanceRequirementCardId() {
		return maintenanceRequirementCardId;
	}

	public void setMaintenanceRequirementCardId(int maintenanceRequirementCardId) {
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	@Override
	public String toString() {
		return "CardHasPart [maintenanceRequirementCardId=" + maintenanceRequirementCardId + ", partId=" + partId + "]";
	}
	

}
