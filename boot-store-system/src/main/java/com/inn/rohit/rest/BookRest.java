package com.inn.rohit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inn.rohit.model.Books;
import com.inn.rohit.wrapper.BookRequest;

@RequestMapping("/book")
public interface BookRest {
	
	@GetMapping("getBooks")
    List<Books> getBooks();

    @PostMapping("addBook")
    Books addBook(@RequestBody BookRequest bookRequest);

    @PutMapping("updateBook")
    Books updateBook(@RequestBody Books book, @RequestParam(name = "bookId") Integer id);

    @DeleteMapping("deleteBook")
    Books deleteBook(@RequestParam(name = "bookId") Integer id);

    @GetMapping("getBook")
    Books getBook(@RequestParam(name = "bookId", required = false) Integer id, @RequestParam(name = "bookTitle", required = false) String title);
}




