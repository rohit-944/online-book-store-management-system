package com.inn.rohit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.rohit.model.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
	
	List<Users> findByName(String name);

}
