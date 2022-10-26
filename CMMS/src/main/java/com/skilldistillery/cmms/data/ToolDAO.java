package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.User;

public interface ToolDAO {

	public Tool findById(int toolId);
	
	public Tool createTool(Tool tool);

	public List<Tool> findAll();

}
