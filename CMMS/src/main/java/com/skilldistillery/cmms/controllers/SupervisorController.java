package com.skilldistillery.cmms.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.cmms.data.MaintenanceItemDAO;
import com.skilldistillery.cmms.entities.MaintenanceItem;
import com.skilldistillery.cmms.entities.User;

@Controller
public class SupervisorController {
	
	@Autowired
	private MaintenanceItemDAO taskDao;
	
	
	
	
	
	@RequestMapping(path = "scheduleMaintenance.do", method = RequestMethod.GET)
	public String calanderView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "scheduleMaintenance";
		} else
			return "login";
	}
	
//	@RequestMapping(path = "supMaintenance.do", method = RequestMethod.GET)
//	public String viewSupervisorMaintenance(HttpSession session, Model model) {
//		MaintenanceItem item = null;
//		if (session.getAttribute("loggedInUser") != null) {
//			List<MaintenanceItem> tasks = taskDao.findAll();
//			
//			Collections.sort(tasks,  item.getCompletionDate() );
//			for(MaintenanceItem task : tasks) {
//				
//			}
//			model.addAttribute("MaintenanceItems", tasks);
//			return "supMaintenance";
//		} else
//			return "login";
//	}
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(path = "supTools.do", method = RequestMethod.GET)
	public String toolSupervisorView(HttpSession session, Model model, User tech) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supTools";
		} else
			return "login";
	}

	@RequestMapping(path = "supTraining.do", method = RequestMethod.GET)
	public String trainingSupervisorView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supTraining";
		} else
			return "login";
	}

	@RequestMapping(path = "supTechnicians.do", method = RequestMethod.GET)
	public String techniciansSupervisorView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supTechnicians";
		} else
			return "login";
	}

	@RequestMapping(path = "supMaintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailSupervisorView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supMaintenanceDetail";
		} else
			return "login";
	}

	@RequestMapping(path = "supEquipment.do", method = RequestMethod.GET)
	public String equipmentSupervisorView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supEquipment";
		} else
			return "login";
		
	}

	
}
