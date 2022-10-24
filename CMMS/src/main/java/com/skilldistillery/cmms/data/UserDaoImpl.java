package com.skilldistillery.cmms.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
		User oldUser = findById(userId);
		User newUser;
		
		return null;
	}

}
