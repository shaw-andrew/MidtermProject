package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.Tool;

public interface ToolDAO {

	public Tool findById(int toolId);
	
	public Tool createTool(Tool tool);

	public List<Tool> findAll();
<<<<<<< HEAD
	
	public boolean deleteTool(int toolId);

=======
	public List<Tool> findallByStaffId(Staff staff);
>>>>>>> e43137a4d836cd842493227c00427a4f3b7910d5

}
