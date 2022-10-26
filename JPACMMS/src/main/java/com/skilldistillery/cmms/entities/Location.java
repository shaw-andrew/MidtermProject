package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;

	@Column(name = "street_2")
	private String street2;

	private String city;

	@Column(name = "state_abbrev")
	private String stateAbbrev;

	@Column(name = "zip_code")
	private int zipCode;
	
	@OneToMany (mappedBy = "location")
	private List<Staff> staff;
	
	@OneToMany (mappedBy = "supervisedLocation")
	private List<Staff> supervisingStaff;
	
	@OneToMany (mappedBy = "location")
	private List<Equipment> equipment;

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public Location() {
		super();

	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public Location(int id, String street, String street2, String city, String stateAbbrev, int zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.stateAbbrev = stateAbbrev;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateAbbrev() {
		return stateAbbrev;
	}

	public void setStateAbbrev(String stateAbbrev) {
		this.stateAbbrev = stateAbbrev;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	

	public List<Staff> getSupervisingStaff() {
		return supervisingStaff;
	}

	public void setSupervisingStaff(List<Staff> supervisingStaff) {
		this.supervisingStaff = supervisingStaff;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Street: " + street + " Street 2: " + street2 + " City: " + city
				+ " State: " + stateAbbrev + " Zip Code: " + zipCode;
	}

	
	
}
