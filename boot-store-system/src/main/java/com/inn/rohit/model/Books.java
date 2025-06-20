package com.inn.rohit.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class Books {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookpk_id")
	private Integer id;
	
	@Column(name = "title",length = 255, nullable = false)
	private String title;
	
	@Column(name = "author",length = 100, nullable = false)
	private String author;
	
	@Column(name = "isbn",length = 13, nullable = false, unique = true)
	private String isbn;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(nullable = false)
    private Integer stock;

    // Foreign key to category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryfk_id")
    @JsonIgnore
    private Categories categoriesfk;

    // Foreign key to user (who wrote/added the book)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userfk_id")
    @JsonIgnore
    private Users usersfk;

    @Column(name = "creation_time", updatable = false)
    private LocalDateTime creationTime = LocalDateTime.now();

	public Books() {
		super();
		// TODO Auto-generated constructor stub
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categories getCategoriesfk() {
		return categoriesfk;
	}

	public void setCategoriesfk(Categories categoriesfk) {
		this.categoriesfk = categoriesfk;
	}

	public Users getUsersfk() {
		return usersfk;
	}

	public void setUsersfk(Users usersfk) {
		this.usersfk = usersfk;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", stock=" + stock + ", categoriesfk=" + categoriesfk + ", usersfk=" + usersfk + ", creationTime="
				+ creationTime + "]";
	}	
	
	
}
