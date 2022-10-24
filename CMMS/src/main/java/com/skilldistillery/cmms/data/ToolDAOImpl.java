package com.skilldistillery.cmms.data;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Tool;
@Service
@Transactional
public class ToolDAOImpl implements ToolDAO {

	private Map<Integer, Tool> tool;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Tool findById(int toolId) {
		return em.find(Tool.class, toolId);
	}

}
