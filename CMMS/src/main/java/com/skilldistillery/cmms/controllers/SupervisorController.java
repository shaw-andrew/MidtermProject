package com.skilldistillery.cmms.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.cmms.data.EquipmentDAO;
import com.skilldistillery.cmms.data.MaintenanceItemDAO;
import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.data.UserDAO;
import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.Training;
import com.skilldistillery.cmms.entities.User;

@Controller
public class SupervisorController {
	
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
	public String toolSupervisorView(HttpSession session, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			List<Tool> tools = toolDao.findAll();
			model.addAttribute("tools", tools);
			return "supTools";
		} else
			return "login";
	}
	
	
	
	
	@RequestMapping(path = "supTraining.do", method = RequestMethod.GET)
	public String trainingSupervisorView(HttpSession session, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			List<Training> trainings = trainingDao.findAll();
			model.addAttribute("trainings", trainings);
			return "supTraining";
		} else
			return "login";
	}
	
	@RequestMapping(path = "supEquipment.do", method = RequestMethod.GET)
	public String equipmentSupervisorView(HttpSession session, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			List<Equipment> equipment = equipmentDao.findAll();
			model.addAttribute("equipment", equipment);
			return "supEquipment";
		} else
			return "login";
		
	}
	
	
//	@RequestMapping(path = "supTechnicians.do", method = RequestMethod.GET)
//	public String techniciansSupervisorView(HttpSession session) {
//		if (session.getAttribute("loggedInUser") != null) {
//			List<User> techs = userDao.findAll();
//			model.addAttribute("techs", techs);
//			return "supTechnicians";
//		} else
//			return "login";
//	}
	




	@RequestMapping(path = "supMaintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailSupervisorView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "supMaintenanceDetail";
		} else
			return "login";
	}
	
	@RequestMapping(path = "account.do", method = RequestMethod.GET)
	public String accountDetailSupView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "account";
		} else
			return "login";
	}
	
	@RequestMapping(path = "addOrUpdate.do", method = RequestMethod.GET)
	public String accountManagementView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "addOrUpdate";
		} else
			return "login";
	}
	
	@RequestMapping(path = "updatePassword.do", method = RequestMethod.GET)
	public String updatePassword(HttpSession session, RedirectAttributes redir, int id, User user) {
		if (session.getAttribute("loggedInUser") != null) {
			User update = userDao.updatePassword(id, user);
			redir.addFlashAttribute("update", update);
			return "redirect:updatePasswordConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path="updatePasswordConfirmation.do", method = RequestMethod.GET)
	public String updatePasswordConfirmation() {
		return "updatePasswordConfirmation";
	}

	
}
