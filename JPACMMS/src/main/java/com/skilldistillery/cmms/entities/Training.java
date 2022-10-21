package com.skilldistillery.cmms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "video_url")
	private String videoURL;
	
	@Column(name = "mrc_id")
	private int mrcId;
	
	private String category;
	
	private String description;
	
	public Training() {}
	
	public Training(int id, String videoURL, int mrcId, String category, String description) {
		super();
		this.id = id;
		this.videoURL = videoURL;
		this.mrcId = mrcId;
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

	public int getMrcId() {
		return mrcId;
	}

	public void setMrcId(int mrcId) {
		this.mrcId = mrcId;
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
		return "Training [id=" + id + ", videoURL=" + videoURL + ", mrcId=" + mrcId + ", category=" + category
				+ ", description=" + description + "]";
	}
	
	
}
