package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.User;

public interface TechnicianDAO {
	
	User findById(int userId);
	
	List<Staff> findAllAtLocation(int locationId);
	
	

}
