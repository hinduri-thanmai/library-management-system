package com.thanmai.librarymanagement.service;

import com.thanmai.librarymanagement.dto.BookDTO;
import com.thanmai.librarymanagement.entity.Book;

import java.util.List;

public interface BookService {

    Book addBook(BookDTO bookDTO);

    Book updateBook(Long bookId, BookDTO bookDTO);

    void deleteBook(Long bookId);

    List<Book> getAllBooks();

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> searchByCategory(String category);
}