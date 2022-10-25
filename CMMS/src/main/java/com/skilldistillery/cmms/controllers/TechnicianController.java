package com.skilldistillery.cmms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.cmms.data.EquipmentDAO;
import com.skilldistillery.cmms.data.MaintenanceItemDAO;
import com.skilldistillery.cmms.data.PartDAO;
import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.data.UserDAO;

@Controller
public class TechnicianController {
	
	@Autowired
	private ToolDAO toolDao;
	@Autowired
	private EquipmentDAO equipmentDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private MaintenanceItemDAO maintenanceItemDAO;
	@Autowired
	private TrainingDAO trainingDao;
	@Autowired
	private PartDAO partDao;
	
	
	//goes to tools jsp and from there they can view tools needed for job, tasks, and parts
	//has to find tools using the dao
	@RequestMapping(path = "tools.do", method = RequestMethod.GET)
	public String toolView(HttpSession session, Integer toolId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			if(toolId == null) {
				toolId = 1;
			}
//			Tool tool = toolDao.findById(1);
			//FIXME
			model.addAttribute("parts", partDao.findAll());
			model.addAttribute("tools",toolDao.findAll());
			return "tools";
		} else
			return "login";
	}

	@RequestMapping(path = "training.do", method = RequestMethod.GET)
	public String trainingView(HttpSession session, Integer trainingId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
//			Training training = trainingDao.findById(1);
			//FIXME
			model.addAttribute("training",trainingDao.findAll());
			return "training";
		} else
			return "login";
	}

	@RequestMapping(path = "technicians.do", method = RequestMethod.GET)
	public String techniciansView(HttpSession session, Integer technicianId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
//			User user = userDao.findById(1);
			//FIXME
			model.addAttribute("user", userDao.findAll());
			return "technicians";
		} else
			return "login";
	}

	@RequestMapping(path = "maintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailView(HttpSession session, Model model, Integer id) {
		if (session.getAttribute("loggedInUser") != null) {
//			MaintenanceRequirementCard mrc = mrcDAO.findById(1);
			//FIXME
			model.addAttribute("maintenanceItems", maintenanceItemDAO.findAll());
			return "maintenanceDetail";
		} else
			return "login";
	}
	
	

	@RequestMapping(path = "equipment.do", method = RequestMethod.GET)
	public String equipmentView(HttpSession session, Integer equipmentId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
//			Equipment equipment = equipmentDao.findById(1);
			//FIXME
			
			model.addAttribute("equipment",equipmentDao.findAll());
			return "equipment";
		} else
			return "login";
	}
	
	
	//tools, maintenance , maintenance details

	
}