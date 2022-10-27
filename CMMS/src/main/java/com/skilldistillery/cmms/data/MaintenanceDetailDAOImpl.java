package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;
import com.skilldistillery.cmms.entities.Part;
import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.User;


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
		String jpql = "SELECT mrc FROM MaintenanceRequirementCard mrc JOIN mrc.equipmentType et JOIN et.equipment eq where eq.location.id = :location";
		
		
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
		 MaintenanceRequirementCard deleteMRC = em.find(MaintenanceRequirementCard.class, mrcId);
	        if (deleteMRC != null) { 
	            em.remove(deleteMRC); 
	        }
	        return em.contains(deleteMRC); 
	}
	
	@Override
	public void addToolToCard(int toolId, int mrcId) {
		Tool tool = em.find(Tool.class, toolId);
		MaintenanceRequirementCard updateMrc = em.find(MaintenanceRequirementCard.class, mrcId);
		updateMrc.addTool(tool);
	}
	
	@Override
	public void addPartToCard(int partId, int mrcId) {
		Part part = em.find(Part.class, partId);
		MaintenanceRequirementCard updateMrc = em.find(MaintenanceRequirementCard.class, mrcId);
		updateMrc.addPart(part);
	}
	
//	@Override
//	public void addTrainingToCard(int trainingId, int mrcId) {
//		Training training = em.find(Training.class, trainingId);
//		MaintenanceRequirementCard updateMrc = em.find(MaintenanceRequirementCard.class, mrcId);
//		updateMrc.addTraining(training);
//	}
	
	@Override
	public MaintenanceRequirementCard updateMrc(int mrcId, MaintenanceRequirementCard mrc) {
		MaintenanceRequirementCard updateMrc = em.find(MaintenanceRequirementCard.class, mrcId);
		updateMrc.setFrequency(mrc.getFrequency());
		updateMrc.setDescription(mrc.getDescription());
		updateMrc.setEquipmentType(mrc.getEquipmentType());
		updateMrc.setEstimatedDurationInHours(mrc.getEstimatedDurationInHours());
		return updateMrc;
	}
}
