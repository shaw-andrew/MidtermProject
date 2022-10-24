package com.skilldistillery.cmms.data;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.skilldistillery.cmms.entities.MaintenanceItem;

public class MaintenanceItemDAOImpl implements MaintenanceItemDAO {

	private Map<Integer, MaintenanceItem> task;
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public MaintenanceItem findById(int maintenanceItemId) {
		
		
		return em.find(MaintenanceItem.class, maintenanceItemId);
	}
	

}
