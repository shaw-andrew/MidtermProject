package com.skilldistillery.cmms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.cmms.data.EquipmentDAO;
import com.skilldistillery.cmms.data.MaintenanceDetailDAO;
import com.skilldistillery.cmms.data.MaintenanceItemDAO;
import com.skilldistillery.cmms.data.PartDAO;
import com.skilldistillery.cmms.data.TechnicianDAO;
import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.data.UserDAO;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;

@Controller
public class EditMrcController {
	
	@Autowired
	private MaintenanceItemDAO taskDao;
	@Autowired
	private ToolDAO toolDao;
	@Autowired
	private TrainingDAO trainingDao;
	@Autowired
	private EquipmentDAO equipmentDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private TechnicianDAO techDao;
	@Autowired
	private MaintenanceDetailDAO mrcDao;
	@Autowired
	private PartDAO partDao;
	
	@RequestMapping(path = "editMrcPage.do", method = RequestMethod.GET)
	public String viewMRCToEdit(HttpSession session, int id, Model model ) {
		
		if (session.getAttribute("loggedInUser") != null) {
			MaintenanceRequirementCard mrc = mrcDao.findById(id);
			model.addAttribute("mrcs", mrc);
			model.addAttribute("tools", toolDao.findAll());
			model.addAttribute("parts", partDao.findAll());
			model.addAttribute("trainings", trainingDao.findAll());
			
			return "editMRC";
		} else
			return "login";
	}

}
