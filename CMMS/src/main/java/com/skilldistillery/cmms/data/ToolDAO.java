package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.Tool;

public interface ToolDAO {

	Tool findById(int toolId);
	public List<Tool> findAll();
	public List<Tool> findallByStaffId(Staff staff);

}
