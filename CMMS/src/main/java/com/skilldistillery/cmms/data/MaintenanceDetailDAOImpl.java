package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

@Service
@Transactional
public class MaintenanceDetailDAOImpl implements MaintenanceDetailDAO {
	@PersistenceContext
	private EntityManager em;
	
	Map<Integer, MaintenanceRequirementCard> mrc;

	@Override
	public MaintenanceRequirementCard findById(int id) {
		
		return em.find(MaintenanceRequirementCard.class, id);
	}
	
	@Override
	public List<MaintenanceRequirementCard> findAll() {
		String jpql = "SELECT mrc FROM MaintenanceRequirementCard mrc";
		return em.createQuery(jpql, MaintenanceRequirementCard.class).getResultList();
	}

}
