package com.skilldistillery.cmms.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name ="maintenance_item")
@Entity
public class MaintenanceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="completion_date")
	private LocalDateTime completionDate;
	
	@Column(name="actual_duration_in_hours")
	private double actualDurationInHours;
	
	@Column(name="tech_notes")
	private String techNotes;
	
	@Column(name="schedule_start_date")
	private LocalDateTime scheduleStartDate;
	
	
	
	@ManyToOne
	@JoinColumn(name="maintenance_requirement_card_id")
	private MaintenanceRequirementCard mrc;
	
	
	@Column(name="schedule_end_date")
	private LocalDateTime scheduleEndDate;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	public MaintenanceItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MaintenanceItem(int id, LocalDateTime completionDate, double actualDurationInHours, String techNotes,
			LocalDateTime scheduleStartDate, MaintenanceRequirementCard mrc, LocalDateTime scheduleEndDate, Staff staff,
			Equipment equipment) {
		super();
		this.id = id;
		this.completionDate = completionDate;
		this.actualDurationInHours = actualDurationInHours;
		this.techNotes = techNotes;
		this.scheduleStartDate = scheduleStartDate;
		this.mrc = mrc;
		this.scheduleEndDate = scheduleEndDate;
		this.staff = staff;
		this.equipment = equipment;
	}
	
//	public void addEquipment(Equipment equipmentStuff) {
//		if (equipment == null) {
//			equipment= new ArrayList<>();
//		}
//		if (!equipment.contains(equipmentStuff)) {
//			equipment.add(equipmentStuff);
//			equipment.addTask(this);
//		}
//	}
//
//	public void removeTask(MaintenanceItem mainItem) {
//		if (equipment != null && equipment.contains(mainItem)) {
//			equipment.remove(mainItem);
//			equipment.remove(this);
//		}
//	}
//	







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDateTime completionDate) {
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

	public LocalDateTime getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(LocalDateTime scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public MaintenanceRequirementCard getMrc() {
		return mrc;
	}

	public void setMrc(MaintenanceRequirementCard mrc) {
		this.mrc = mrc;
	}

	public LocalDateTime getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(LocalDateTime scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "Maintenance Item ID: " + id + " \nCompletion Date: " + completionDate + " \nActual Duration In Hours: "
				+ actualDurationInHours + " \nTech Notes: " + techNotes + " \nSchedule Start Date: " + scheduleStartDate
				+ " \nSchedule End Date: " + scheduleEndDate;
	}
	
	
	
	

}
