package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.User;

public interface TechnicianDAO {
	
	User findById(int userId);
	
	

}
