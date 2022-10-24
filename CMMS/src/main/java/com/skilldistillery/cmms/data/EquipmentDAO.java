package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.Equipment;

public interface EquipmentDAO {
	
	Equipment findById(int equipmentId);

}
