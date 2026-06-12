package com.thanmai.librarymanagement.controller;

import com.thanmai.librarymanagement.dto.BookDTO;
import com.thanmai.librarymanagement.entity.Book;
import com.thanmai.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search/title/{title}")
    public List<Book> searchByTitle(@PathVariable String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/search/author/{author}")
    public List<Book> searchByAuthor(@PathVariable String author) {
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/search/category/{category}")
    public List<Book> searchByCategory(@PathVariable String category) {
        return bookService.searchByCategory(category);
    }
}