package com.skilldistillery.cmms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.cmms.data.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
}
