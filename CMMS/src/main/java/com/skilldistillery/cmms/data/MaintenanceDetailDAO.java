package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

public interface MaintenanceDetailDAO {
	
	MaintenanceRequirementCard findById(int id);
	public List<MaintenanceRequirementCard> findAll();

}
