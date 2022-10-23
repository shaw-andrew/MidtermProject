package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "maintenance_requirement_card")
@Entity
public class MaintenanceRequirementCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name = "number_of_techs")
	private int numberOfTechs;

	@Column(name = "training_video_id")
	private String trainingVideoId;

	@Column(name = "estimated_duration_in_hours")
	private double estimatedDurationInHours;

	@Column(name = "frequency_id")
	private int frequencyId;

	@Column(name = "equipment_type_id")
	private int equipmentTypeId;

	@ManyToMany(mappedBy = "cards")
	private List<Certification> certifications;

	@ManyToMany(mappedBy = "cards")
	private List<Safety> safety;

	@ManyToMany(mappedBy = "cards")
	private List<Part> parts;

	@ManyToMany(mappedBy = "cards")
	private List<Tool> tools;

	public MaintenanceRequirementCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaintenanceRequirementCard(int id, String description, int numberOfTechs, String trainingVideoId,
			double estimatedDurationInHours, int frequencyId, int equipmentTypeId, List<Certification> certifications,
			List<Safety> safety, List<Part> parts, List<Tool> tools) {
		super();
		this.id = id;
		this.description = description;
		this.numberOfTechs = numberOfTechs;
		this.trainingVideoId = trainingVideoId;
		this.estimatedDurationInHours = estimatedDurationInHours;
		this.frequencyId = frequencyId;
		this.equipmentTypeId = equipmentTypeId;
		this.certifications = certifications;
		this.safety = safety;
		this.parts = parts;
		this.tools = tools;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfTechs() {
		return numberOfTechs;
	}

	public void setNumberOfTechs(int numberOfTechs) {
		this.numberOfTechs = numberOfTechs;
	}

	public String getTrainingVideoId() {
		return trainingVideoId;
	}

	public void setTrainingVideoId(String trainingVideoId) {
		this.trainingVideoId = trainingVideoId;
	}

	public double getEstimatedDurationInHours() {
		return estimatedDurationInHours;
	}

	public void setEstimatedDurationInHours(double estimatedDurationInHours) {
		this.estimatedDurationInHours = estimatedDurationInHours;
	}

	public int getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(int frequencyId) {
		this.frequencyId = frequencyId;
	}

	public int getEquipmentTypeId() {
		return equipmentTypeId;
	}

	public void setEquipmentTypeId(int equipmentTypeId) {
		this.equipmentTypeId = equipmentTypeId;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Safety> getSafety() {
		return safety;
	}

	public void setSafety(List<Safety> safety) {
		this.safety = safety;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

	@Override
	public String toString() {
		return "MaintenanceRequirementCard [id=" + id + ", description=" + description + ", numberOfTechs="
				+ numberOfTechs + ", trainingVideoId=" + trainingVideoId + ", estimatedDurationInHours="
				+ estimatedDurationInHours + ", frequencyId=" + frequencyId + ", equipmentTypeId=" + equipmentTypeId
				+ ", certifications=" + certifications + ", safety=" + safety + ", parts=" + parts + ", tools=" + tools
				+ "]";
	}

}
