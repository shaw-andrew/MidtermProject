package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.MaintenanceItem;

@Service
@Transactional
public class MaintenanceItemDAOImpl implements MaintenanceItemDAO {

	//private Map<Integer, MaintenanceItem> task;
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public MaintenanceItem findById(int maintenanceItemId) {
		
		return em.find(MaintenanceItem.class, maintenanceItemId);
	}

	@Override
	public List<MaintenanceItem> findAll() {
		String jpql = "SELECT item FROM MaintenanceItem item";
		return em.createQuery(jpql, MaintenanceItem.class).getResultList();
	}

	@Override
	public MaintenanceItem updateText(int mainItemId, MaintenanceItem mainItem) {
		MaintenanceItem updateMainItem = em.find(MaintenanceItem.class, mainItemId);
		updateMainItem.setTechNotes(mainItem.getTechNotes());
		return updateMainItem;
	}

	@Override
	public MaintenanceItem updateCompletionDate(int mainItemId, MaintenanceItem mainItem) {
		MaintenanceItem updateMainItem = em.find(MaintenanceItem.class, mainItemId);
		updateMainItem.setCompletionDate(mainItem.getCompletionDate());
		return updateMainItem;
	}
	
	
	

}
