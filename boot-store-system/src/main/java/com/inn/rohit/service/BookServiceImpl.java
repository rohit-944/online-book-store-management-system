package com.inn.rohit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.rohit.custum.exception.BusinessException;
import com.inn.rohit.dao.BookDao;
import com.inn.rohit.dao.CategoriesDao;
import com.inn.rohit.dao.UserDao;
import com.inn.rohit.model.Books;
import com.inn.rohit.model.Categories;
import com.inn.rohit.wrapper.BookRequest;

@Service
public class BookServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
    private UserDao userDao;
	
	@Autowired
	private CategoriesDao categoriesDao;
	
    @Autowired
    private BookDao bookDao;

    public List<Books> getBooks() {
        logger.info("Fetching all books");
        try {
            List<Books> books = bookDao.findAll();
            logger.info("Number of books found: {}", books.size());
            logger.info("Books details: {}", books.toString());
            if (books.isEmpty()) {
                logger.warn("No books found in the database.");
            }
            return books;
        } catch (Exception e) {
            logger.error("Error fetching books: {}", e.getMessage());
            throw new RuntimeException("Error fetching books: " + e.getMessage());
        }
    }

    public Books addBook(BookRequest bookRequest) {
        logger.info("Adding new book: {}", bookRequest.toString());
        try {
            if (bookRequest == null || bookRequest.getTitle() == null || bookRequest.getIsbn() == null) {
                throw new BusinessException("Book data is incomplete");
            }
            Books obook=new Books();
            obook.setTitle(bookRequest.getTitle());
            obook.setAuthor(bookRequest.getAuthor());
            obook.setIsbn(bookRequest.getIsbn());
            obook.setPrice(bookRequest.getPrice());
            obook.setStock(bookRequest.getStock());
            obook.setCategoriesfk(categoriesDao.findById((long)bookRequest.getCategoryid()).get());
            obook.setUsersfk(userDao.findById(bookRequest.getUserid()).get());
            obook.setCreationTime(LocalDateTime.now());            
            logger.info("Book details before saving: {}", obook.toString());            
            return bookDao.save(obook);
        } catch (Exception e) {
            logger.error("Error adding book: {}", e.getMessage());
            throw new RuntimeException("Error adding book: " + e.getMessage());
        }
    }

    public Books updateBook(Integer id, Books bookDetails) {
        logger.info("Updating book with ID: {}, Data: {}", id, bookDetails);
        try {
            if (id == null || bookDetails == null) {
                throw new BusinessException("Book data or ID is incomplete");
            }
            Books existingBook = bookDao.findById(id)
                .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));
            
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setIsbn(bookDetails.getIsbn());
            existingBook.setPrice(bookDetails.getPrice());
            existingBook.setStock(bookDetails.getStock());
            existingBook.setCategoriesfk(bookDetails.getCategoriesfk());
            existingBook.setUsersfk(bookDetails.getUsersfk());
            existingBook.setCreationTime(LocalDateTime.now());

            return bookDao.save(existingBook);
        } catch (Exception e) {
            logger.error("Error updating book: {}", e.getMessage());
            throw new RuntimeException("Error updating book: " + e.getMessage());
        }
    }

    public Books deleteBook(Integer id) {
        logger.info("Deleting book with ID: {}", id);
        if (id == null) {
            throw new BusinessException("Book ID is required for deletion");
        }
        try {
            Books book = bookDao.findById(id)
                .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));
            bookDao.delete(book);
            return book;
        } catch (Exception e) {
            logger.error("Error deleting book: {}", e.getMessage());
            throw new RuntimeException("Error deleting book: " + e.getMessage());
        }
    }

    public Books getBook(Integer id, String title) {
        logger.info("Fetching book with ID: {}, Title: {}", id, title);
        try {
            // Handle null or empty both
            if (id == null && (title == null)) {
                throw new BusinessException("Invalid request: either book ID or title must be provided");
            }

            if (id != null) {
                return bookDao.findById(id)
                    .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));
            } else {
                return bookDao.findByTitle(title.trim())
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new BusinessException("Book not found with title: " + title));
            }
        } catch (Exception e) {
            logger.error("Error fetching book: {}", e.getMessage());
            throw new RuntimeException("Error fetching book: " + e.getMessage());
        }
    }
}
