package com.inn.rohit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inn.rohit.model.Books;
import com.inn.rohit.srvices.BookService;

@RestController
public class MyController {
	
	@Autowired
	private BookService bookServices;
	
	// Get All Books
	@GetMapping("/books")
	public List<Books> getBooks(){
		
		return bookServices.getBooks();
		
	}
	
	@PostMapping("/addBook")
	public Books addBook(@RequestBody Books book) {
		
		return bookServices.addBook(book);
	} 

}
