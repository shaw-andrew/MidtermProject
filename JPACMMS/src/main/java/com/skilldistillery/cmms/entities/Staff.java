package com.skilldistillery.cmms.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
//	@Column(name = "user_id")
//	private int userId;

	@Column(name = "manager_id")
	private int managerId;

	@ManyToOne
	@JoinColumn(name = "supervised_location_id")
	private Integer supervisedLocationId;

	@OneToOne
	@JoinColumn
	(name = "user_id")
	private User user;
	
	@Column(name="supervisor_id")
	private int supervisorId;
	
	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Location supervisorLocation;

	@ManyToMany(mappedBy = "staff")
	private List<Certification> certifications;

	public Staff() {
	}

	public Staff(int id, String firstName, String lastName, int locationId, int managerId, int supervisedLocationId,
			User user, int supervisorId, Location location, List<Certification> certifications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.locationId = locationId;
		this.managerId = managerId;
		this.supervisedLocationId = supervisedLocationId;
		this.user = user;
		this.supervisorId = supervisorId;
		this.location = location;
		this.certifications = certifications;
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

//	public int getLocationId() {
//		return locationId;
//	}
//
//	public void setLocationId(int locationId) {
//		this.locationId = locationId;
//	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Integer getSupervisedLocationId() {
		return supervisedLocationId;
	}

	public void setSupervisedLocationId(Integer supervisedLocationId) {
		this.supervisedLocationId = supervisedLocationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

	public Location getSupervisorLocation() {
		return supervisorLocation;
	}

	public void setSupervisorLocation(Location supervisorLocation) {
		this.supervisorLocation = supervisorLocation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, 
//				locationId, 
				managerId, supervisedLocationId 
//				, userId
				);
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", locationId="
	
//				locationId
				+ ", managerId=" + managerId + ", supervisedLocationId=" + supervisedLocationId + ", user=" + user
				+ ", supervisorId=" + supervisorId + ", location=" + location + ", certifications=" + certifications
				+ "]";
	}

}
