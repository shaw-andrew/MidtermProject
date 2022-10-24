package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.Training;


public interface TrainingDAO {
	public Training findById(int trainingId);
	

	public List<Training> findAll();
		

}