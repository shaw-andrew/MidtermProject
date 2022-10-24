package com.skilldistillery.cmms.data;

import java.util.Map;

import javax.persistence.EntityManager;

import com.skilldistillery.cmms.entities.User;

public class TechnicianDAOImpl implements TechnicianDAO {

	private EntityManager em;
	
	private Map <User, Integer> user;
	
	@Override
	public User findById(int userId) {
		
		return em.find(User.class, userId);
	}

	

}
