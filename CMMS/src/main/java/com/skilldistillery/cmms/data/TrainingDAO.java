package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Training;

public interface TrainingDAO {
	
	public Training createTraining(Training training);
	
	public Training findById(int trainingId);

	public List<Training> findAll();
	
	public boolean deleteTraining(int trainingId);


}