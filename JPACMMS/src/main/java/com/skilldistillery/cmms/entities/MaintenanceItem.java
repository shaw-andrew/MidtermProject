package com.skilldistillery.cmms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaintenanceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="completion_date")
	private LocalDate completionDate;
	@Column(name="actual_duration_in_hours")
	private double actualDurationInHours;
	@Column(name="tech_notes")
	private String techNotes;
	@Column(name="schedule_start_date")
	private LocalDate scheduleStartDate;
	@Column(name="maintenance_requirement_card_id")
	private int maintenanceRequirementCardId;
	@Column(name="equipment_id")
	private int equipmentId;
	@Column(name="schedule_end_date")
	private LocalDate scheduleEndDate;
	@Column(name="staff_id")
	private int staffId;
	public MaintenanceItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaintenanceItem(int id, LocalDate completionDate, double actualDurationInHours, String techNotes,
			LocalDate scheduleStartDate, int maintenanceRequirementCardId, int equipmentId, LocalDate scheduleEndDate,
			int staffId) {
		super();
		this.id = id;
		this.completionDate = completionDate;
		this.actualDurationInHours = actualDurationInHours;
		this.techNotes = techNotes;
		this.scheduleStartDate = scheduleStartDate;
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
		this.equipmentId = equipmentId;
		this.scheduleEndDate = scheduleEndDate;
		this.staffId = staffId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	public double getActualDurationInHours() {
		return actualDurationInHours;
	}
	public void setActualDurationInHours(double actualDurationInHours) {
		this.actualDurationInHours = actualDurationInHours;
	}
	public String getTechNotes() {
		return techNotes;
	}
	public void setTechNotes(String techNotes) {
		this.techNotes = techNotes;
	}
	public LocalDate getScheduleStartDate() {
		return scheduleStartDate;
	}
	public void setScheduleStartDate(LocalDate scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}
	public int getMaintenanceRequirementCardId() {
		return maintenanceRequirementCardId;
	}
	public void setMaintenanceRequirementCardId(int maintenanceRequirementCardId) {
		this.maintenanceRequirementCardId = maintenanceRequirementCardId;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public LocalDate getScheduleEndDate() {
		return scheduleEndDate;
	}
	public void setScheduleEndDate(LocalDate scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	@Override
	public String toString() {
		return "MaintenanceItem [id=" + id + ", completionDate=" + completionDate + ", actualDurationInHours="
				+ actualDurationInHours + ", techNotes=" + techNotes + ", scheduleStartDate=" + scheduleStartDate
				+ ", maintenanceRequirementCardId=" + maintenanceRequirementCardId + ", equipmentId=" + equipmentId
				+ ", scheduleEndDate=" + scheduleEndDate + ", staffId=" + staffId + "]";
	}
	
	
	
}
