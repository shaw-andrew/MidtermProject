package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CertificationHasStaff {

	@Column(name = "certification_id")
	private int certificationId;

	@Column(name = "staff_id")
	private int staffId;

	public CertificationHasStaff() {
		super();
	}

	public CertificationHasStaff(int certificationId, int staffId) {
		super();
		this.certificationId = certificationId;
		this.staffId = staffId;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "CertificationHasStaff [certificationId=" + certificationId + ", staffId=" + staffId + "]";
	}

}
