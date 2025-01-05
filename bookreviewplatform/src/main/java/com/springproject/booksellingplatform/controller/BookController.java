package com.springproject.booksellingplatform.controller;

import com.springproject.booksellingplatform.model.Book;
import com.springproject.booksellingplatform.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //Fix CORS errors
@RequestMapping("/booksellingplatform")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn){

        Book book = service.getBookByISBN(isbn);

        if(book != null)
            return new ResponseEntity<>(book,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book book)
    {
        service.addNewBook(book);
    }

    @PutMapping("/book")
    public ResponseEntity<String> updateBook(@RequestBody Book book)
    {
        Book p = service.updateBookDetails(book);
        if(p != null)
        {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping ("/book/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn)
    {
        Book p = service.getBookByISBN(isbn);
        if(p != null)
        {
            service.deleteBook(isbn);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/books/search")
    public ResponseEntity<List<Book>> getBooksBySearch(@RequestParam String keyword)
    {
        List<Book> prodList = service.getBookListBySearch(keyword);
        return new ResponseEntity<>(prodList,HttpStatus.OK);
    }
}
