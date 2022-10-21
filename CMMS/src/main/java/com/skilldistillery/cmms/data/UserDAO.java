package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.User;

public interface UserDAO {

	User findById(int userId);
	
	User getUserByUserNameAndPassword(String username, String password);
	
	User updateUser(int userId, User user);
}
