package com.springproject.booksellingplatform.service;

import com.springproject.booksellingplatform.model.Book;
import com.springproject.booksellingplatform.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookByISBN(String isbn) {
        return bookRepo.getBookByISBN(isbn);
    }

    public void addNewBook(Book book) {
        try {
            bookRepo.save(book);
        } catch (StaleObjectStateException e) {
            // Handle conflict, e.g., refresh the entity or retry
            System.out.println("Conflict detected: " + e.getMessage());
        }
    }

    public Book updateBookDetails(Book book) {
        return bookRepo.save(book);
    }

    @Transactional
    public void deleteBook(String isbn) {
        bookRepo.deleteBookByISBN(isbn);
    }

    public List<Book> getBookListBySearch(String keyword) {
        return bookRepo.searchBooks(keyword);
    }
}
