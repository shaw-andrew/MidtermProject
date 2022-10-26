package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Location;
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

	@Override
	public List<MaintenanceRequirementCard> findAllByLocation(Location location) {
//		String jpql = "SELECT mrcs FROM Equipment e JOIN e.maintenanceItem where e.location.id = :location";
//		String jpql = "SELECT m FROM MaintenanceRequirementCard m JOIN m.equipmentType et JOIN Equipment e where e.location.id = :location";
		String jpql = "SELECT mrc FROM MaintenanceRequirementCard mrc JOIN mrc.tasks t where t.equipment.location.id = :location";
		
		
		List<MaintenanceRequirementCard>  mrcs = em.createQuery(jpql, MaintenanceRequirementCard.class).setParameter("location", location.getId()).getResultList();
		return mrcs;
	}
	
	@Override
	public MaintenanceRequirementCard createMRC(MaintenanceRequirementCard mrc) {
		em.persist(mrc);
		return mrc;
	}

	@Override
	public boolean deleteMRC(int mrcId) {
		// TODO Auto-generated method stub
		return false;
	}

}
