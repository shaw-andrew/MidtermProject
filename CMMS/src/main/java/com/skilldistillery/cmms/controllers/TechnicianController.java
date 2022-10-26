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
import com.skilldistillery.cmms.data.PartDAO;
import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.data.UserDAO;
import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceItem;
import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.Tool;
import com.skilldistillery.cmms.entities.User;

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

	// goes to tools jsp and from there they can view tools needed for job, tasks,
	// and parts
	// has to find tools using the dao
	@RequestMapping(path = "tools.do", method = RequestMethod.GET)
	public String toolView(HttpSession session, Integer toolId, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {

			Staff staff = user.getStaff();
			List<Tool> tools = toolDao.findallByStaffId(staff);

//			if (toolId == null) {
//				toolId = 1;
//			}
//			Tool tool = toolDao.findById(1);
			// FIXME
			model.addAttribute("parts", partDao.findAll());
			model.addAttribute("tools", tools);
			return "tools";
		} else
			return "login";
	}

	@RequestMapping(path = "training.do", method = RequestMethod.GET)
	public String trainingView(HttpSession session, Integer trainingId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
//			Training training = trainingDao.findById(1);
			// FIXME
			model.addAttribute("training", trainingDao.findAll());
			return "training";
		} else
			return "login";
	}

	@RequestMapping(path = "technicians.do", method = RequestMethod.GET)
	public String techniciansView(HttpSession session, Integer technicianId, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
//			User user = userDao.findById(1);
			// FIXME
			model.addAttribute("user", userDao.findAll());
			return "technicians";
		} else
			return "login";
	}

	@RequestMapping(path = "maintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailView(HttpSession session, Model model, Integer id) {
		User user = (User)session.getAttribute("loggedInUser");
		if (user != null) {
			
			Staff staff = user.getStaff();
			
			
			List<MaintenanceItem> mainItem = maintenanceItemDAO.findAllByStaffId(staff);
//			MaintenanceRequirementCard mrc = mrcDAO.findById(1);
			// FIXME
			model.addAttribute("maintenanceItems", mainItem);
			return "maintenanceDetail";
		} else
			return "login";
	}

	@RequestMapping(path = "equipment.do", method = RequestMethod.GET)
	public String equipmentView(HttpSession session, Integer equipmentId, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
			Location locationId = user.getStaff().getLocation();
			List<Equipment> equipment = equipmentDao.findAllByLocation(locationId);
			model.addAttribute("equipment", equipment);

			return "equipment";
		} else
			return "login";
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public String completionView(HttpSession session, int mainItemId, RedirectAttributes redir,
			MaintenanceItem mainItem) {
		if (session.getAttribute("loggedInUser") != null) {
			System.out.println(mainItem);
			MaintenanceItem update = maintenanceItemDAO.updateAll(mainItemId, mainItem);
//			redir.addFlashAttribute("maintenanceItems",update);
			return "redirect:maintenanceDetail.do";
		} else
			return "login";
	}

	@RequestMapping(path = "updateMaintenanceItem.do", method = RequestMethod.POST)
	public String updateMaintenanceItem(HttpSession session, int mainItemId, RedirectAttributes redir,
			MaintenanceItem mainItem) {
		if (session.getAttribute("loggedInUser") != null) {
			MaintenanceItem update = maintenanceItemDAO.updateAll(mainItemId, mainItem);
			redir.addFlashAttribute("maintenanceItems", update);
			return "redirect:maintenanceDetail.do";
		} else
			return "login";
	}

	@RequestMapping(path = "updateAllComplete.do", method = RequestMethod.GET)
	public String updateAllComplete() {
		return "updateAllComplete";
	}

//	@RequestMapping(path = "submitNotes.do", method = RequestMethod.POST)
//	public String notesView(HttpSession session, RedirectAttributes redir, int id, MaintenanceItem mainItem) {
//		if (session.getAttribute("loggedInUser") != null) {
//			MaintenanceItem update = maintenanceItemDAO.updateText(id, mainItem);
//			redir.addFlashAttribute("update", update);
//
//			return "redirect:updateNotesConfirmation.do";
//		} else
//			return "login";
//	}
//
//	@RequestMapping(path = "updateNotesConfirmation.do", method = RequestMethod.GET)
//	public String updateNotesConfirmation() {
//		return "maintenanceDetail";
//	}
}