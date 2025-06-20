package com.inn.rohit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Categories {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "categoriespk_id")
	 private Long id;

	 @Column(nullable = false, unique = true, length = 100)
	 private String name;

	 @Column(columnDefinition = "TEXT")
	 private String description;
	 
	 

	 public Categories() {
		super();
		// TODO Auto-generated constructor stub
	 }



	 public Long getId() {
		 return id;
	 }



	 public void setId(Long id) {
		 this.id = id;
	 }



	 public String getName() {
		 return name;
	 }



	 public void setName(String name) {
		 this.name = name;
	 }



	 public String getDescription() {
		 return description;
	 }



	 public void setDescription(String description) {
		 this.description = description;
	 }



	 @Override
	 public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", description=" + description + "]";
	 }
	 
	 
	 
	 
	
}
