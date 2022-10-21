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

	public MaintenanceRequirementCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaintenanceRequirementCard(int id, String description, int numberOfTechs, String trainingVideoId,
			double estimatedDurationInHours, int frequencyId, int equipmentTypeId) {
		super();
		this.id = id;
		this.description = description;
		this.numberOfTechs = numberOfTechs;
		this.trainingVideoId = trainingVideoId;
		this.estimatedDurationInHours = estimatedDurationInHours;
		this.frequencyId = frequencyId;
		this.equipmentTypeId = equipmentTypeId;
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

	@Override
	public String toString() {
		return "MaintenanceRequirementCard [id=" + id + ", description=" + description + ", numberOfTechs="
				+ numberOfTechs + ", trainingVideoId=" + trainingVideoId + ", estimatedDurationInHours="
				+ estimatedDurationInHours + ", frequencyId=" + frequencyId + ", equipmentTypeId=" + equipmentTypeId
				+ "]";
	}

}
