package com.springproject.bookreviewplatform.repository;

import com.springproject.bookreviewplatform.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT b FROM Book b WHERE b.ISBN = :isbn")
    Book getBookByISBN(String isbn);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.ISBN = :isbn")
    void deleteBookByISBN(String isbn);

    @Query("SELECT b FROM Book b WHERE " +
            "LOWER(b.ISBN) LIKE LOWER (CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.BookName) LIKE LOWER (CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.Author) LIKE LOWER (CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.Category) LIKE LOWER (CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.Description) LIKE LOWER (CONCAT('%', :keyword, '%'))")
    List<Book> searchBooks(String keyword);
}

