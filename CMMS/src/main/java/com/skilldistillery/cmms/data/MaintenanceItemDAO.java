package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.MaintenanceItem;


public interface MaintenanceItemDAO {
	
	MaintenanceItem findById(int maintenanceItemId);

	List<MaintenanceItem> findAll();
	
	MaintenanceItem updateAll(int mainItemId, MaintenanceItem mainItem);
	
}