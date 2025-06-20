package com.inn.rohit.rest.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inn.rohit.model.Users;
import com.inn.rohit.rest.UserRest;
import com.inn.rohit.service.UserServiceImpl;

@RestController
public class UserRestImpl implements UserRest {
	
	//add logger define here
	private static final Logger logger = LoggerFactory.getLogger(UserRestImpl.class);
	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public List<Users> getUsers() {
		logger.info("Fetching all users");
		return userService.getUsers();
	}

	@Override
	public Users addUser(Users users) {
		logger.info("Adding new user: {}", users.toString());
		return userService.addUser(users);
	}

	@Override
	public Users updateUser(Users users, Integer id) {
		logger.info("Updating user with ID: {}, Data: {}", id, users.toString());
		return userService.updateUser(users, id);
	}

	@Override
	public Users deteteUser(Integer uId) {
		logger.info("Deleting user with ID: {}", uId);
		return userService.deteteUser(uId);
	}

	@Override
	public Users getUser(Integer uId, String uName) {
		logger.info("Fetching user with ID: {}, Name: {}", uId, uName);
		return userService.getUser(uId, uName);
	}

}
