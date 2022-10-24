package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.User;

public interface ToolDAO {

	Tool findById(int toolId);

}
