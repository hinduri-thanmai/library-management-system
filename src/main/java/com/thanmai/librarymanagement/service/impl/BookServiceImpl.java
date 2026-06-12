package com.thanmai.librarymanagement.service.impl;

import com.thanmai.librarymanagement.dto.BookDTO;
import com.thanmai.librarymanagement.entity.Book;
import com.thanmai.librarymanagement.enums.BookStatus;
import com.thanmai.librarymanagement.repository.BookRepository;
import com.thanmai.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setCategory(bookDTO.getCategory());
        book.setQuantity(bookDTO.getQuantity());
        book.setAvailableQuantity(bookDTO.getQuantity());
        book.setStatus(BookStatus.AVAILABLE);

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, BookDTO bookDTO) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setCategory(bookDTO.getCategory());
        book.setQuantity(bookDTO.getQuantity());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> searchByCategory(String category) {
        return bookRepository.findByCategoryContainingIgnoreCase(category);
    }
}