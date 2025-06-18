package com.inn.rohit.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String isbn;
	@Column
	private Integer price;
	
	@Column
	private Integer stock;
	
	@Column
	private Integer creationId;
	
	@Column
	private Date creationTime;
	
	
	
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Books(Integer id, String title, String author, String isbn, Integer price, Integer stock, Integer creationId,
			Date creationTime) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.stock = stock;
		this.creationId = creationId;
		this.creationTime = creationTime;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getIsbn() {
		return isbn;
	}




	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public Integer getPrice() {
		return price;
	}




	public void setPrice(Integer price) {
		this.price = price;
	}




	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public Integer getCreationId() {
		return creationId;
	}




	public void setCreationId(Integer creationId) {
		this.creationId = creationId;
	}




	public Date getCreationTime() {
		return creationTime;
	}




	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}




	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", stock=" + stock + ", creationId=" + creationId + ", creationTime=" + creationTime + "]";
	}
	
	
	
	
}
