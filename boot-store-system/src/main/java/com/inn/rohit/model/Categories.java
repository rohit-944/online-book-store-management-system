package com.inn.rohit.model;

public class Categories {
	
	private Integer id;
	private String name;
	private String description;
	
	
	
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Categories(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
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
