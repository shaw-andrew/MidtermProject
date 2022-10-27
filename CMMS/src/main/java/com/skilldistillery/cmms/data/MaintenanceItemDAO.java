package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceItem;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;
import com.skilldistillery.cmms.entities.Staff;


public interface MaintenanceItemDAO {
	
	MaintenanceItem findById(int maintenanceItemId);

	List<MaintenanceItem> findAll();
	
	MaintenanceItem updateAll(int mainItemId, MaintenanceItem mainItem);
	
	MaintenanceItem supUpdateAll(int mainItemId, MaintenanceItem mainItem);
	
	List<MaintenanceItem> findAllByLocation(Location locationid);
	public List<MaintenanceItem> findAllByStaffId(Staff staff);
	
	MaintenanceItem createTask(MaintenanceItem task, MaintenanceRequirementCard mrc, Equipment equip, 
			Staff staff);
	
}