package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Part;
@Service
@Transactional
public class PartDAOImpl implements PartDAO {
	
	private Map<Part, Integer> part;

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Part findById(int partId) {
		
		return em.find(Part.class, partId);
	}

	@Override
	public List<Part> findAll() {
		String jpql = "SELECT part FROM Part part";
		return em.createQuery(jpql, Part.class).getResultList();
	}

	@Override
	public Part createPart(Part part) {
		em.persist(part);
		em.flush();
		return part;
	}

}
