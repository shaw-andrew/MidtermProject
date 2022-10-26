package com.skilldistillery.cmms.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Staff;
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

	@Override
	public List<Tool> findAll() {
		String jpql = "SELECT tool FROM Tool tool";
		return em.createQuery(jpql, Tool.class).getResultList();
	}

	@Override
	public Tool createTool(Tool tool) {
		em.persist(tool);
		em.flush();
		return tool;

	}

	@Override
	public List<Tool> findallByStaffId(Staff staff) {
		String jpql = "SELECT tool FROM Tool tool JOIN tool.cards mrc JOIN mrc.tasks t WHERE t.staff.id = :id";
		List<Tool> tools = em.createQuery(jpql, Tool.class).setParameter("id", staff.getId()).getResultList();
		return tools;
	}

	@Override
	public boolean deleteTool(int toolId) {
		// TODO Auto-generated method stub
		return false;
	}
}

