package com.skilldistillery.cmms.data;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.Training;

@Controller
public class TechnicianController {
	
	@Autowired
	private ToolDAO toolDao;
	
	@Autowired
	private TrainingDAO trainingDao;
	
	
	//goes to tools jsp and from there they can view tools needed for job, tasks, and parts
	//has to find tools using the dao
	@RequestMapping(path = "tools.do", method = RequestMethod.GET)
	public String toolView(HttpSession session, Integer toolId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			Tool tool = toolDao.findById(toolId);
			model.addAttribute("tool",tool);
			return "tools";
		} else
			return "login";
	}

	@RequestMapping(path = "training.do", method = RequestMethod.GET)
	public String trainingView(HttpSession session, Integer trainingId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			Training training = trainingDao.findById(trainingId);
			model.addAttribute("training",training);
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
	
	
	//tools, training , maintenance , maintenance details

	
}