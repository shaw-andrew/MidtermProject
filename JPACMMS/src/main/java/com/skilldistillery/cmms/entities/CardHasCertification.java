package com.skilldistillery.cmms.entities;

import javax.persistence.Entity;

@Entity
public class CardHasCertification {

	private int certificationId;

	private int maintenanceRequirementCardId;
	
	public CardHasCertification() {}

	public CardHasCertification(int certificationId, int maintenanceRequirementCardId) {
		super();
		this.certificationId = certificationId;
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public int getMaintenanceRequirementCardId() {
		return maintenanceRequirementCardId;
	}

	public void setMaintenanceRequirementCardId(int maintenanceRequirementCardId) {
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}

	@Override
	public String toString() {
		return "CardHasCertification [certificationId=" + certificationId + ", maintenanceRequirementCardId="
				+ maintenanceRequirementCardId + "]";
	}

}
