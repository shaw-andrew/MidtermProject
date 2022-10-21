package com.skilldistillery.cmms.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "location_id")
	private int locationId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "manager_id")
	private int managerId;
	
	@Column(name = "supervised_location_id")
	private int supervisedLocationId;
	
	public Staff() {}

	public Staff(int id, String firstName, String lastName, int locationId, int userId, int managerId,
			int supervisedLocationId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.locationId = locationId;
		this.userId = userId;
		this.managerId = managerId;
		this.supervisedLocationId = supervisedLocationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getSupervisedLocationId() {
		return supervisedLocationId;
	}

	public void setSupervisedLocationId(int supervisedLocationId) {
		this.supervisedLocationId = supervisedLocationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, locationId, managerId, supervisedLocationId, userId);
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", locationId=" + locationId
				+ ", userId=" + userId + ", managerId=" + managerId + ", supervisedLocationId=" + supervisedLocationId
				+ "]";
	}
	
	
	
	
	
}
