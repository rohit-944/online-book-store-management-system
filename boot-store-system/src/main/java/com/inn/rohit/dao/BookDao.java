package com.inn.rohit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.rohit.model.Books;

@Repository
public interface BookDao extends JpaRepository<Books, Integer> {
	
	
    List<Books> findByTitle(String name);
    
    
}
