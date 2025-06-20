package com.inn.rohit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.rohit.custum.exception.BusinessException;
import com.inn.rohit.dao.UserDao;
import com.inn.rohit.model.Users;

@Service
public class UserServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	public List<Users> getUsers() {
		logger.info("Fetching all users");
		try {
			List<Users> usersList = userDao.findAll();
			if (usersList.isEmpty()) {
				logger.warn("No users found in the database.");
			} 
			return usersList;			
		} catch (Exception e) {
			logger.error("Error fetching users: {}", e.getMessage());
			throw new RuntimeException("Error fetching users: " + e.getMessage()); 
		}
	}

	
	public Users addUser(Users users) {
		logger.info("Adding new user: {}", users.toString());
		try {
			if (users == null || users.getName() == null || users.getEmail() == null) {
				throw new BusinessException("User data is incomplete");
			}
			users.setCreationTime(LocalDateTime.now());
			return userDao.save(users);
		} catch (Exception e) {
			logger.error("Error adding user: {}", e.getMessage());
			throw new RuntimeException("Error adding user: " + e.getMessage());
		}
	}

	
	public Users updateUser(Users users, Integer id) {
		logger.info("Updating user with ID: {}, Data: {}", id, users.toString());
		try {
			if (users == null || id == null) {
				throw new BusinessException("User data or ID is incomplete");
			}
			Users existingUser = userDao.findById(id).orElseThrow(() -> new BusinessException("User not found"));
			existingUser.setName(users.getName());
			existingUser.setEmail(users.getEmail());
			existingUser.setCreationTime(LocalDateTime.now());
			return userDao.save(existingUser);
		} catch (Exception e) {
			logger.error("Error updating user: {}", e.getMessage());
			throw new RuntimeException("Error updating user: " + e.getMessage());
		}
	}

	
	public Users deteteUser(Integer uId) {
		logger.info("Deleting user with ID: {}", uId);
		if (uId == null) {
			throw new BusinessException("User ID is required for deletion");
		}
		try {
			Users user = userDao.findById(uId).orElseThrow(() -> new BusinessException("User not found"));
			userDao.delete(user);
			return user;
		} catch (Exception e) {
			logger.error("Error deleting user: {}", e.getMessage());
			throw new RuntimeException("Error deleting user: " + e.getMessage());
		}
	}

	
	public Users getUser(Integer uId, String uName) {
		logger.info("Fetching user with ID: {}, Name: {}", uId, uName);
		try {
			if (uId == null && (uName == null || uName.isEmpty())) {
				throw new BusinessException("Either user ID or user name must be provided");
			}
			if (uId != null) {
				return userDao.findById(uId).get();
			} else {
				return userDao.findByName(uName).get(0);
			}
			
		} catch (Exception e) {
			logger.error("Error fetching user: {}", e.getMessage());
			throw new RuntimeException("Error fetching user: " + e.getMessage());
		}
		
	}

}
