package com.skilldistillery.cmms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name = "location_id")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "supervised_location_id")
	private Integer supervisedLocationId;

	@Column(name = "manager_id")
	private Integer managerId;

	@ManyToOne
	@JoinColumn(name = "supervised_location_id")
	private Location supervisedLocation;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "supervisor_id")
	private int supervisorId;

	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Location supervisorLocation;

	@ManyToMany(mappedBy = "staff")
	private List<Certification> certifications;

	public Staff() {
	}

	public Staff(int id, String firstName, String lastName, Location location, Integer managerId,
			Location supervisedLocation, User user, List<Certification> certifications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.managerId = managerId;
		this.supervisedLocation = supervisedLocation;
		this.user = user;
		this.certifications = certifications;
	}

	public void addCertification(Certification certification) {
		if (certifications == null) {
			certifications = new ArrayList<>();
		}
		if (!certifications.contains(certification)) {
			certifications.add(certification);
			certification.addStaff(this);
		}
	}

	public void removeCertification(Certification certification) {
		if (certifications != null && certifications.contains(certification)) {
			certifications.remove(certification);
			certification.removeStaff(this);
		}
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

	public Location getLocation() {
		return location;
	}

	public Integer getSupervisedLocationId() {
		return supervisedLocationId;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Location getSupervisedLocation() {
		return supervisedLocation;
	}

	public void setSupervisedLocation(Location supervisedLocation) {
		this.supervisedLocation = supervisedLocation;
	}

	public User getUser() {
		return user;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Location getSupervisorLocation() {
		return supervisorLocation;
	}

	public void setSupervisorLocation(Location supervisorLocation) {
		this.supervisorLocation = supervisorLocation;
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

	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location
				+ ", managerId=" + managerId + ", supervisedLocation=" + supervisedLocation + ", user=" + user
				+ ", certifications=" + certifications + "]";
	}

}
