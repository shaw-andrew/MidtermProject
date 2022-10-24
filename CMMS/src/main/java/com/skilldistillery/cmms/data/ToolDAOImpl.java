package com.skilldistillery.cmms.data;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.skilldistillery.cmms.entities.Tool;
public class ToolDAOImpl implements ToolDAO {

	private Map<Integer, Tool> tool;
	@PersistenceContext
	private EntityManager em;

	@Override
	public Tool findById(int toolId) {
		// TODO Auto-generated method stub
		return em.find(Tool.class, toolId);
	}

}
