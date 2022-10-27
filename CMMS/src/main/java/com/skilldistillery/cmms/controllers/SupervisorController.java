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
import com.skilldistillery.cmms.data.MaintenanceDetailDAO;
import com.skilldistillery.cmms.data.MaintenanceItemDAO;
import com.skilldistillery.cmms.data.PartDAO;
import com.skilldistillery.cmms.data.TechnicianDAO;
import com.skilldistillery.cmms.data.ToolDAO;
import com.skilldistillery.cmms.data.TrainingDAO;
import com.skilldistillery.cmms.data.UserDAO;
import com.skilldistillery.cmms.entities.Equipment;
import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.MaintenanceItem;
import com.skilldistillery.cmms.entities.MaintenanceRequirementCard;
import com.skilldistillery.cmms.entities.Part;
import com.skilldistillery.cmms.entities.Staff;
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
	@Autowired
	private TechnicianDAO techDao;
	@Autowired
	private MaintenanceDetailDAO mrcDao;
	@Autowired
	private PartDAO partDao;

	@RequestMapping(path = "scheduleMaintenance.do", method = RequestMethod.GET)
	public String calanderView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "scheduleMaintenance";
		} else
			return "login";
	}

	@RequestMapping(path = "createMaintenance.do", method = RequestMethod.GET)
	public String createNewMaintenance(HttpSession session, int mrcId, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {

			model.addAttribute("mrc", mrcDao.findById(mrcId));
			model.addAttribute("staff", taskDao.findStaffByLocation(user.getStaff().getLocation().getId()));
			// model.addAttribute("equipment",
			// equipmentDao.findAllByLocation(user.getStaff().getLocation()));
			return "supCreateMaintenanceItem";
		} else
			return "login";
	}

	@RequestMapping(path = "supMaintenance.do", method = RequestMethod.GET)
	public String viewSupervisorMaintenance(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {

			Location locationId = user.getStaff().getSupervisedLocation();
			List<MaintenanceItem> tasks = taskDao.findAllByLocation(locationId);

			model.addAttribute("MaintenanceItems", tasks);
			return "supMaintenance";
		} else
			return "login";
	}

	@RequestMapping(path = "supUpdateTask.do", method = RequestMethod.POST)
	public String completionView(HttpSession session, int mainItemId, RedirectAttributes redir,
			MaintenanceItem mainItem) {
		if (session.getAttribute("loggedInUser") != null) {
			System.out.println(mainItem);
			MaintenanceItem update = taskDao.supUpdateAll(mainItemId, mainItem);
//			redir.addFlashAttribute("maintenanceItems",update);
			return "redirect:supMaintenanceDetail.do";
		} else
			return "login";
	}

	@RequestMapping(path = "supUpdateAllComplete.do", method = RequestMethod.GET)
	public String updateAllComplete() {
		return "updateAllComplete";
	}

	@RequestMapping(path = "supTools.do", method = RequestMethod.GET)
	public String toolSupervisorView(HttpSession session, Model model) {
		if (session.getAttribute("loggedInUser") != null) {
			List<Tool> tools = toolDao.findAll();
			model.addAttribute("tools", tools);
			return "supTools";
		} else
			return "login";
	}

	@RequestMapping(path = "deleteTool.do", method = RequestMethod.POST)
	public String deleteTool(int ToolId) {
		if(toolDao.deleteTool(ToolId) == true) {
		return "deleteToolConfirmation";
		}else {
			return "unsuccessful";
		}
	}

	@RequestMapping(path = "addTool.do", method = RequestMethod.GET)
	public String addToolBySup(HttpSession session, User user, Tool tool) {
		if (session.getAttribute("loggedInUser") != null) {
			return "addTool";
		} else
			return "login";
	}

	@RequestMapping(path = "persistTool.do", method = RequestMethod.POST)
	public String addTool(HttpSession session, RedirectAttributes redir, Tool tool) {
		if (session.getAttribute("loggedInUser") != null) {
			Tool newTool = toolDao.createTool(tool);
			redir.addFlashAttribute("newTool", newTool);
			return "redirect:addToolConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "addToolConfirmation.do", method = RequestMethod.GET)
	public String addToolConfirmation() {
		return "addToolConfirmation";
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

	@RequestMapping(path = "addTraining.do", method = RequestMethod.GET)
	public String addTrainingBySup(HttpSession session, User user, Training training) {
		if (session.getAttribute("loggedInUser") != null) {
			return "addTraining";
		} else
			return "login";
	}

	@RequestMapping(path = "persistTraining.do", method = RequestMethod.POST)
	public String addTraining(HttpSession session, RedirectAttributes redir, Training training) {
		if (session.getAttribute("loggedInUser") != null) {
			Training newTraining = trainingDao.createTraining(training);
			redir.addFlashAttribute("newTraining", newTraining);
			return "redirect:addTrainingConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "addTrainingConfirmation.do", method = RequestMethod.GET)
	public String addTrainingConfirmation() {
		return "addTrainingConfirmation";
	}

	@RequestMapping(path = "supEquipment.do", method = RequestMethod.GET)
	public String equipmentSupervisorView(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
			Location locationId = user.getStaff().getSupervisedLocation();
			List<Equipment> equipment = equipmentDao.findAllByLocation(locationId);
			model.addAttribute("equipment", equipment);
			return "supEquipment";
		} else
			return "login";

	}

	@RequestMapping(path = "deleteEquipment.do", method = RequestMethod.POST)
	public String deleteEquipment(int equipmentId) {
		if (equipmentDao.deleteEquipment(equipmentId) == true) {
			return "deleteEquipmentConfirmation";
		} else {
			return "unsuccessful";
		}

	}

	@RequestMapping(path = "addEquipment.do", method = RequestMethod.GET)
	public String addEquipmentBySup(HttpSession session, User user, Equipment equipment) {
		if (session.getAttribute("loggedInUser") != null) {
			return "addEquipment";
		} else
			return "login";
	}

	@RequestMapping(path = "persistEquipment.do", method = RequestMethod.POST)
	public String addEquipment(HttpSession session, RedirectAttributes redir, Equipment equipment, int eqpType) {
		User currentUser = (User) session.getAttribute("loggedInUser");
		if (currentUser != null) {
			int newLocationId = currentUser.getStaff().getLocation().getId();
			Equipment newEquipment = equipmentDao.createEquipment(equipment, eqpType, newLocationId);
			redir.addFlashAttribute("newEquipment", newEquipment);
			return "redirect:addEquipmentConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "addEquipmentConfirmation.do", method = RequestMethod.GET)
	public String addEquipmentConfirmation() {
		return "addEquipmentConfirmation";
	}

	@RequestMapping(path = "supTechnicians.do", method = RequestMethod.GET)
	public String techniciansSupervisorView(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
			Location locationId = user.getStaff().getSupervisedLocation();
			List<Staff> staff = techDao.findAllAtLocation(locationId);
			model.addAttribute("staff", staff);
			return "supTechnicians";
		} else
			return "login";
	}

	@RequestMapping(path = "supMaintenanceDetail.do", method = RequestMethod.GET)
	public String maintenanceDetailSupervisorView(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {

			Location locationId = user.getStaff().getSupervisedLocation();

			List<MaintenanceRequirementCard> mrcs = mrcDao.findAllByLocation(locationId);

			model.addAttribute("mrcs", mrcs);

			return "supMaintenanceDetail";
		} else
			return "login";
	}

	@RequestMapping(path = "deleteMRC.do", method = RequestMethod.POST)
	public String deleteMRC(int mrcId) {
		if (mrcDao.deleteMRC(mrcId) == true) {
			return "deleteMaintenanceDetail";
		} else {
			return "unsuccessful";
		}
	}

	@RequestMapping(path = "persistPart.do", method = RequestMethod.POST)
	public String addPart(HttpSession session, RedirectAttributes redir, Part part) {
		if (session.getAttribute("loggedInUser") != null) {
			Part newPart = partDao.createPart(part);
			redir.addFlashAttribute("newPart", newPart);
			return "redirect:addPartConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "addPartConfirmation.do", method = RequestMethod.GET)
	public String addPartConfirmation() {
		return "addPartConfirmation";
	}

	@RequestMapping(path = "account.do", method = RequestMethod.GET)
	public String accountDetailSupView(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "account";
		} else
			return "login";
	}

	@RequestMapping(path = "addUser.do", method = RequestMethod.GET)
	public String accountManagementView(HttpSession session, User user, Staff staff) {
		if (session.getAttribute("loggedInUser") != null) {
			return "addUser";
		} else
			return "login";
	}

	@RequestMapping(path = "updatePassword.do", method = RequestMethod.POST)
	public String updatePassword(HttpSession session, RedirectAttributes redir, int id, String password) {
		if (session.getAttribute("loggedInUser") != null) {
			User update = userDao.updatePassword(id, password);
			redir.addFlashAttribute("update", update);
			return "redirect:updatePasswordConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "updatePasswordConfirmation.do", method = RequestMethod.GET)
	public String updatePasswordConfirmation() {
		return "updatePasswordConfirmation";
	}

	@RequestMapping(path = "persistUser.do", method = RequestMethod.POST)
	public String addUser(HttpSession session, RedirectAttributes redir, Staff staff, User user) {
		User currentUser = (User) session.getAttribute("loggedInUser");
		if (currentUser != null) {
			Staff newUser = userDao.addUser(user, staff, currentUser.getStaff().getLocation().getId());
			redir.addFlashAttribute("newUser", newUser);
			return "redirect:addUserConfirmation.do";
		} else
			return "login";
	}

	@RequestMapping(path = "addUserConfirmation.do", method = RequestMethod.GET)
	public String addUserConfirmation() {
		return "addUserConfirmation";
	}

}
