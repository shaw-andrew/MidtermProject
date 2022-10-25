package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Location;
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
	public MaintenanceItem updateAll(int mainItemId, MaintenanceItem mainItem) {
		MaintenanceItem updateMainItem = em.find(MaintenanceItem.class, mainItemId);
		updateMainItem.setTechNotes(mainItem.getTechNotes());
		updateMainItem.setCompletionDate(mainItem.getCompletionDate());
		updateMainItem.setActualDurationInHours(mainItem.getActualDurationInHours());
		em.persist(updateMainItem);
		return updateMainItem;
	}

	@Override
	public List<MaintenanceItem> findAllByLocation(Location location) {
		String jpql = "SELECT task FROM MaintenanceItem task where task.staff.location.id = :location";
		List<MaintenanceItem> tasks = em.createQuery(jpql, MaintenanceItem.class).setParameter("location", location.getId()).getResultList();
		return tasks;
	}
		
}
