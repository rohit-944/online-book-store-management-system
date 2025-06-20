package com.inn.rohit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inn.rohit.model.Users;

@RequestMapping("/user")
public interface UserRest {
	
	@GetMapping("getUsers")
	List<Users> getUsers();
	
	@PostMapping("addUser")
	Users addUser(@RequestBody Users users);
	
	@PutMapping("updateUser")
	Users updateUser(@RequestBody Users users, @RequestParam(name = "userId", required = true) Integer id);

	@DeleteMapping("deleteUser")
	Users deteteUser(@RequestParam(name = "userId", required = true) Integer uId);
	
	@GetMapping("getUser")
	Users getUser(@RequestParam(name = "userId", required = false) Integer uId, @RequestParam(name = "userName", required = false) String uName);


}
