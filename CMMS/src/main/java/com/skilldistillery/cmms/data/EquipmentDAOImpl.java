package com.skilldistillery.cmms.data;

import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Equipment;

@Service
@Transactional
public class EquipmentDAOImpl implements EquipmentDAO {

	private Map<Integer, Equipment> equipment;
	@PersistenceContext
	private EntityManager em;

	@Override
	public Equipment findById(int equipmentId) {
		// TODO Auto-generated method stub
		return em.find(Equipment.class, equipmentId);
	}

}
