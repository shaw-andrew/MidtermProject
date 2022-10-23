package com.skilldistillery.cmms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy= "mrc")
	private List <Training> trainings;
	
	

	@Column(name = "estimated_duration_in_hours")
	private double estimatedDurationInHours;

	@ManyToOne
	@JoinColumn(name = "frequency_id")
	private Frequency frequency;

	@ManyToOne
	@JoinColumn(name = "equipment_type_id")
	private EquipmentType equipmentType;

	@ManyToMany(mappedBy = "cards")
	private List<Certification> certifications;
	
	@ManyToMany(mappedBy = "cards")
	private List<Safety> safety;
	
	@ManyToMany(mappedBy = "cards")
	private List<Part> parts;
	
	@ManyToMany(mappedBy = "cards")
	private List<Tool> tools;
	
	@OneToMany(mappedBy = "mrc")
	private List<MaintenanceItem> tasks;
	
	public MaintenanceRequirementCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaintenanceRequirementCard(int id, String description, int numberOfTechs, String trainingVideoId,
			List<Training> trainings, double estimatedDurationInHours, Frequency frequency, EquipmentType equipmentType,
			List<Certification> certifications, List<Safety> safety, List<Part> parts, List<Tool> tools,
			List<MaintenanceItem> tasks) {
		super();
		this.id = id;
		this.description = description;
		this.numberOfTechs = numberOfTechs;
		this.trainingVideoId = trainingVideoId;
		this.trainings = trainings;
		this.estimatedDurationInHours = estimatedDurationInHours;
		this.frequency = frequency;
		this.equipmentType = equipmentType;
		this.certifications = certifications;
		this.safety = safety;
		this.parts = parts;
		this.tools = tools;
		this.tasks = tasks;
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

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public double getEstimatedDurationInHours() {
		return estimatedDurationInHours;
	}

	public void setEstimatedDurationInHours(double estimatedDurationInHours) {
		this.estimatedDurationInHours = estimatedDurationInHours;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
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

	public List<MaintenanceItem> getTasks() {
		return tasks;
	}

	public void setTasks(List<MaintenanceItem> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "MaintenanceRequirementCard [id=" + id + ", description=" + description + ", numberOfTechs="
				+ numberOfTechs + ", trainingVideoId=" + trainingVideoId + ", trainings=" + trainings
				+ ", estimatedDurationInHours=" + estimatedDurationInHours + ", frequency=" + frequency
				+ ", equipmentType=" + equipmentType + ", certifications=" + certifications + ", safety=" + safety
				+ ", parts=" + parts + ", tools=" + tools + ", tasks=" + tasks + "]";
	}

}
