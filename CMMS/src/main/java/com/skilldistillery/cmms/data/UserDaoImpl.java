package com.skilldistillery.cmms.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.cmms.entities.Location;
import com.skilldistillery.cmms.entities.Staff;
import com.skilldistillery.cmms.entities.User;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	private Map<Integer, User> users;
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		User u = null;
		String sql = "SELECT u FROM User u";
		List<User> users = new ArrayList<>();
		users = em.createQuery(sql, User.class).getResultList();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				u = user;
				break;
			}
		}
		return u;
	}

	@Override
	public User updateUser(int userId, User user) {
		User update = em.find(User.class, userId);
		update.setPassword(user.getPassword());
		update.setUsername(user.getUsername());
		update.setRole(update.getRole());
		update.getStaff().setFirstName(user.getStaff().getFirstName());
		update.getStaff().setLastName(user.getStaff().getLastName());
		return update;
	}
	
	@Override
	public User updatePassword(int userId, String password) {
		User update = em.find(User.class, userId);
		if(update != null) {
		update.setPassword(password);
		}
		return update;
	}
	
	public List<User> findAll(){
		String jpql = "SELECT user FROM User user";
		return em.createQuery(jpql, User.class).getResultList();
	}
	
	@Override
	public Staff addUser(User user, Staff staff, int locNumber) {
		user.setStaff(staff);
		staff.setUser(user);
		staff.setLocation(em.find(Location.class, locNumber));
		user.setEnabled(true);
		em.persist(user);
		em.persist(staff);
		return staff;
	}
	
	@Override
	public Staff findStaffById(int staffId) {
		
		return em.find(Staff.class, staffId);
		
	}
}
