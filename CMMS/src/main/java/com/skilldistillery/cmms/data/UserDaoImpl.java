package com.skilldistillery.cmms.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
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
		// TODO Auto-generated method stub
		return em.find(User.class, userId);
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
