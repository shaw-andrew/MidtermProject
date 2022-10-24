package com.skilldistillery.cmms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.cmms.data.InMemoryUserDAO;
import com.skilldistillery.cmms.entities.User;

@Controller
public class UserController {

//	@Autowired
//	private UserDAO userDao;
	@Autowired
	private InMemoryUserDAO userDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "supervisor.do", method = RequestMethod.GET)
	public String accountView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supervisor";
		} else
			return "login";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String displayLogin(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "home";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String Login(User user, HttpSession session) {
		user = userDao.getUserByUserNameAndPassword(user.getUsername(), user.getPassword());
		if (user != null) {
			session.setAttribute("loggedInUser", user);
			return "supervisor";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "home";
	}

	
}
