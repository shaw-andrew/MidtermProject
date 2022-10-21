package com.skilldistillery.cmms.entities;

import javax.persistence.Column;

public class CardHasSafety {
	@Column(name="safety_id")
	private int safetyId;
	
	@Column(name="maintenance_requirement_card_id")
	private int maintenanceRequirementCardId;

	public CardHasSafety() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardHasSafety(int safetyId, int maintenanceRequirementCardId) {
		super();
		this.safetyId = safetyId;
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	public int getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(int safetyId) {
		this.safetyId = safetyId;
	}

	public int getMaintenanceRequirementCardId() {
		return maintenanceRequirementCardId;
	}

	public void setMaintenanceRequirementCardId(int maintenanceRequirementCardId) {
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	@Override
	public String toString() {
		return "CardHasSafety [safetyId=" + safetyId + ", maintenanceRequirementCardId=" + maintenanceRequirementCardId
				+ "]";
	}
}
