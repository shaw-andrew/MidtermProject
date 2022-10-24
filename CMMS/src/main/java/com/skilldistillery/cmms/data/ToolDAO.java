package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.Tool;

public interface ToolDAO {

	Tool findById(int toolId);
}
