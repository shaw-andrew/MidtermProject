package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.User;

public interface ToolDAO {

	Tool findById(int toolId);
	public List<Tool> findAll();

}
