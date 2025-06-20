package com.inn.rohit.rest.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inn.rohit.model.Books;
import com.inn.rohit.rest.BookRest;
import com.inn.rohit.service.BookServiceImpl;
import com.inn.rohit.wrapper.BookRequest;

@RestController
public class BookRestImpl implements BookRest {

    private static final Logger logger = LoggerFactory.getLogger(BookRestImpl.class);

    @Autowired
    private BookServiceImpl bookService;

    @Override
    public List<Books> getBooks() {
        logger.info("Fetching all books");
        return bookService.getBooks();
    }

    @Override
    public Books addBook(BookRequest bookRequest) {
        logger.info("Adding new book: {}", bookRequest.toString());
        return bookService.addBook(bookRequest);
    }

    @Override
    public Books updateBook(Books book, Integer id) {
        logger.info("Updating book with ID: {}, Data: {}", id, book.toString());
        return bookService.updateBook(id, book);
    }

    @Override
    public Books deleteBook(Integer id) {
        logger.info("Deleting book with ID: {}", id);
        return bookService.deleteBook(id);
    }

    @Override
    public Books getBook(Integer id, String title) {
        logger.info("Fetching book with ID: {}, Title: {}", id, title);
        return bookService.getBook(id, title);
    }
}
