package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;
import com.skilldistillery.cmms.entities.User;
@Service
@Transactional
public class TechnicianDAOImpl implements TechnicianDAO {
	@PersistenceContext
	private EntityManager em;
	
	private Map <User, Integer> user;
	
	@Override
	public User findById(int userId) {
		
		return em.find(User.class, userId);
	}
	
	

}
