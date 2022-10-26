package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;

@Service
@Transactional
public class EquipmentDAOImpl implements EquipmentDAO {

	private Map<Integer, Equipment> equipment;
	@PersistenceContext
	private EntityManager em;

	@Override
	public Equipment findById(int equipmentId) {
		return em.find(Equipment.class, equipmentId);
	}
	
	@Override
	public List<Equipment> findAll() {
		String jpql = "SELECT eq FROM Equipment eq";
		return em.createQuery(jpql, Equipment.class).getResultList();
	}

	@Override
	public List<Equipment> findAllByLocation(Location location) {
		String jpql = "SELECT equip FROM Equipment equip where equip.location.id = :location";
		
		List<Equipment> equipment = em.createQuery(jpql, Equipment.class).setParameter("location", location.getId()).getResultList();
		return equipment;
	}

	@Override
	public Equipment createEquipment(Equipment equipment) {
		em.persist(equipment);
		em.flush();
		return equipment;
	}

}
