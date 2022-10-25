package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Part;

public interface PartDAO {
	Part findById(int partId);
	public List<Part> findAll();

}
