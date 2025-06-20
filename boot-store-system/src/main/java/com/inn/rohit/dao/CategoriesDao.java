package com.inn.rohit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.rohit.model.Categories;

@Repository
public interface CategoriesDao extends JpaRepository<Categories, Long>{

}
