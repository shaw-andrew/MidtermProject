package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.EquipmentType;
import com.skilldistillery.cmms.entities.Frequency;
import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

public interface MaintenanceDetailDAO {

	MaintenanceRequirementCard findById(int id);

	public List<MaintenanceRequirementCard> findAll();

	public List<MaintenanceRequirementCard> findAllByLocation(Location location);

	public MaintenanceRequirementCard createMRC(MaintenanceRequirementCard mrc);

	public boolean deleteMRC(int mrcId);

	public void addToolToCard(int toolId, int mrcId);

	void addPartToCard(int partId, int mrcId);

	MaintenanceRequirementCard updateMrc(int mrcId, MaintenanceRequirementCard mrc);
	
	public List<Frequency> findAllFrequencies();
	
	public List<EquipmentType> findAllEquipmentTypes();

//	void addTrainingToCard(int trainingId, int mrcId);

}
