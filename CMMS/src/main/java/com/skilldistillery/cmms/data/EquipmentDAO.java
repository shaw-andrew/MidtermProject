package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;

public interface EquipmentDAO {

	public Equipment findById(int equipmentId);
	
	public Equipment createEquipment(Equipment equipment);
	
	public boolean deleteEquipment(int equipmentId);

	public List<Equipment> findAll();

	public List<Equipment> findAllByLocation(Location location);

}
