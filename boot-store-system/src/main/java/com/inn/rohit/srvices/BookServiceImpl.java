package com.inn.rohit.srvices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.rohit.dao.BookDao;
import com.inn.rohit.model.Books;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	List<Books> list;
	public BookServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Books(1,"Java", "James Gosling", "978-1260440232", 2000, 20,25,  new Date() ));
	}
	
	
	@Override
	public List<Books> getBooks() {
		List<Books> allbook = bookDao.findAll();
		return allbook;
	}


	@Override
	public Books addBook(Books books) {
		Books booksave = bookDao.save(books);
		return booksave;
	}
	

	

	

}
