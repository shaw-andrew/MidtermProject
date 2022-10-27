package com.skilldistillery.cmms.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceItem;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;
import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.User;

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
	public MaintenanceItem createTask(MaintenanceItem task, MaintenanceRequirementCard mrc, Equipment equip, 
			Staff staff) {
			task.setStaff(staff);
			task.setMrc(mrc);
			task.setEquipment(equip);
			em.persist(task);
			return task;
		}

	@Override
	public MaintenanceItem updateAll(int mainItemId, MaintenanceItem mainItem) {
		MaintenanceItem updateMainItem = em.find(MaintenanceItem.class, mainItemId);
		updateMainItem.setTechNotes(mainItem.getTechNotes());
		updateMainItem.setCompletionDate(mainItem.getCompletionDate());
		updateMainItem.setActualDurationInHours(mainItem.getActualDurationInHours());
//		em.persist(updateMainItem);
		return updateMainItem;
	}
	
	@Override
	public MaintenanceItem supUpdateAll(int mainItemId, MaintenanceItem mainItem) {
		MaintenanceItem updateMainItem = em.find(MaintenanceItem.class, mainItemId);
		updateMainItem.setScheduleStartDate(mainItem.getScheduleStartDate());
		updateMainItem.setScheduleEndDate(mainItem.getScheduleEndDate());
		//updateMainItem.setStaff(mainItem.getStaff());
//		em.persist(updateMainItem);
		return updateMainItem;
	}

	@Override
	public List<MaintenanceItem> findAllByLocation(Location location) {
		String jpql = "SELECT task FROM MaintenanceItem task where task.staff.location.id = :location";
		List<MaintenanceItem> tasks = em.createQuery(jpql, MaintenanceItem.class).setParameter("location", location.getId()).getResultList();
		return tasks;
	}
	
	@Override
	public List<Staff> findStaffByLocation(Location location) {
		String jpql = "SELECT DISTINCT task.staff FROM MaintenanceItem task where task.staff.location.id = :location";
		List<Staff> tasks = em.createQuery(jpql, Staff.class).setParameter("location", location.getId()).getResultList();
		return tasks;
	}
	
	@Override
	public List<MaintenanceItem> findAllByStaffId(int id) {
		String jpql = "SELECT task FROM MaintenanceItem task where task.staff.id = :id";
		List<MaintenanceItem> tasks = em.createQuery(jpql, MaintenanceItem.class).setParameter("id", id).getResultList();
		return tasks;
	}
		
}
