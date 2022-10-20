package com.skilldistillery.cmms.data;

import com.skilldistillery.cmms.entities.User;

public interface UserDAO {

	User findById(int userId);
}
