package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.Staff;
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
	
	@Override
	public List<Staff> findAllAtLocation(Location location) {
		
		String jpql = "SELECT staff FROM Staff staff where staff.location = :location";
		List<Staff> staff = em.createQuery(jpql, Staff.class).setParameter("location", location.getId()).getResultList();
		return staff;
		
	}
	
	

}
