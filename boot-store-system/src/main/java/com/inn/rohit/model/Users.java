package com.inn.rohit.model;

import java.util.Date;


public class Users {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String role;
	private Date creattionTime;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Integer id, String name, String email, String password, String role, Date creattionTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.creattionTime = creattionTime;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreattionTime() {
		return creattionTime;
	}

	public void setCreattionTime(Date creattionTime) {
		this.creattionTime = creattionTime;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", creattionTime=" + creattionTime + "]";
	}

}
