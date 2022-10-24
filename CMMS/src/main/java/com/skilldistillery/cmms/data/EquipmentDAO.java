package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Equipment;

public interface EquipmentDAO {
	
	Equipment findById(int equipmentId);
	public List<Equipment> findAll();

}
