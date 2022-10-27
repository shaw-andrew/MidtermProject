package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

import antlr.build.Tool;

public interface MaintenanceDetailDAO {

	MaintenanceRequirementCard findById(int id);

	public List<MaintenanceRequirementCard> findAll();

	public List<MaintenanceRequirementCard> findAllByLocation(Location location);

	public MaintenanceRequirementCard createMRC(MaintenanceRequirementCard mrc);

	public boolean deleteMRC(int mrcId);

	public void addToolToCard(int toolId, int mrcId);

	void addPartToCard(int partId, int mrcId);

//	void addTrainingToCard(int trainingId, int mrcId);

}
