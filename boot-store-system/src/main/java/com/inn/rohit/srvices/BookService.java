package com.inn.rohit.srvices;

import java.util.List;

import com.inn.rohit.model.Books;

public interface BookService {
	
	public List<Books> getBooks();
	
	public Books addBook(Books books);
	

}
