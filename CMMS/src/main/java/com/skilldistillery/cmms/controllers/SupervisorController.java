package com.skilldistillery.cmms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SupervisorController {

	@RequestMapping(path = "tools.do", method = RequestMethod.GET)
	public String toolView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "tools";
		} else
			return "login";
	}

	@RequestMapping(path = "training.do", method = RequestMethod.GET)
	public String trainingView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "training";
		} else
			return "login";
	}

	@RequestMapping(path = "technicians.do", method = RequestMethod.GET)
	public String techniciansView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "technicians";
		} else
			return "login";
	}

	@RequestMapping(path = "maintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "maintenanceDetail";
		} else
			return "login";
	}

	@RequestMapping(path = "equipment.do", method = RequestMethod.GET)
	public String equipmentView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "equipment";
		} else
			return "login";
		
	}

	
}
