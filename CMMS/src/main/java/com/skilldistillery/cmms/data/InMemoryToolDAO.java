package com.skilldistillery.cmms.data;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.tools.Tool;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryToolDAO implements ToolDAO {
	
	public InMemoryToolDAO() {
	
	}

	@Override
	public com.skilldistillery.cmms.entities.Tool findById(int toolId) {

		return null;
	}

}
