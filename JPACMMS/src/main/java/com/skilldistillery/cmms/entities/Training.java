package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "video_url")
	private String videoURL;
	
	@ManyToOne
	@JoinColumn(name = "mrc_id")
	private MaintenanceRequirementCard mrc;
	

	private String category;
	
	private String description;
	
	public Training() {}
	
	public Training(int id, String videoURL, MaintenanceRequirementCard mrc, String category, String description) {
		super();
		this.id = id;
		this.videoURL = videoURL;
		this.mrc = mrc;
		this.category = category;
		this.description = description;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public MaintenanceRequirementCard getMrc() {
		return mrc;
	}

	public void setMrc(MaintenanceRequirementCard mrc) {
		this.mrc = mrc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", videoURL=" + videoURL + ", category=" + category + ", description="
				+ description + "]";
	}
	
	
}
