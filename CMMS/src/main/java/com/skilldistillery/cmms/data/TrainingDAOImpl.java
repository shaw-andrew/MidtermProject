package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Tool;
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

	@Override
	public List<Training> findAll() {
			String jpql = "SELECT training FROM Training training";
			return em.createQuery(jpql, Training.class).getResultList();
	}

	@Override
	public Training createTraining(Training training) {
		em.persist(training);
		em.flush();
		return training;
	}

	@Override
	public boolean deleteTraining(int trainingId) {
		// TODO Auto-generated method stub
		return false;
	}

}