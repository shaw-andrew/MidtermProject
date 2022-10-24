package com.skilldistillery.cmms.data;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.skilldistillery.cmms.entities.Training;

@Service
@Transactional
public class TrainingDAOImpl implements TrainingDAO {
	
	private Map<Integer, Training> training;
	@PersistenceContext
	private EntityManager em;

	@Override
	public Training findById(int trainingId) {
		// TODO Auto-generated method stub
		return em.find(Training.class, trainingId);
	}

}
