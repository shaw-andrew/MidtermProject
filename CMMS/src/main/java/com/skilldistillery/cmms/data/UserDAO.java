package com.skilldistillery.cmms.data;

import java.util.List;

import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.User;

public interface UserDAO {

	User findById(int userId);
	
	User getUserByUserNameAndPassword(String username, String password);
	
	User updateUser(int userId, User user);
	
	User updatePassword(int userId, String password);

	List<User> findAll();

	Staff addUser(User user, Staff staff);

}
