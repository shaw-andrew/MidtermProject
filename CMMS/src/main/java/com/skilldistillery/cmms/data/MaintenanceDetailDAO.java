package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

public interface MaintenanceDetailDAO {
	
	MaintenanceRequirementCard findById(int id);

}
