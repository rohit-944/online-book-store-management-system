package com.inn.rohit.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Users {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "userspk_id")
	  private Long id;

	  @Column(name = "name", nullable = false, length = 100)
	  private String name;

	  @Column(name = "email", nullable = false, unique = true, length = 100)
	  private String email;

	  @Column(name = "password", nullable = false, length = 255)
	  private String password;

	  
	  @Column(name = "role", nullable = false)
	  private String role ;

	  @Column(name = "creation_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	  private LocalDateTime creationTime;

	  
	  
	  
	  public Users() {
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

	  public LocalDateTime getCreationTime() {
		  return creationTime;
	  }

	  public void setCreationTime(LocalDateTime creationTime) {
		  this.creationTime = creationTime;
	  }



	  @Override
	  public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", creationTime=" + creationTime + "]";
	  }
	  
	  
	  
	  

}
