package com.test.spring.boot.controller;

import java.util.List;

import com.test.spring.boot.model.Author;
import com.test.spring.boot.model.Book;
import com.test.spring.boot.repository.BookRepository;
import com.test.spring.boot.service.AuthorService;
import com.test.spring.boot.service.BookService;
import com.test.spring.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBookById(bookId);
        return  book;
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @PostMapping("/add")
    public void addBook(@RequestParam("name") String name, @RequestParam("author_id") String author_id) {
        Book book = new Book();
        Author author = authorService.getAuthorById(Long.valueOf(author_id));
        if (author != null) {
            book.setName(name);
            book.setAuthor(author);
            bookService.addBook(book);
        }
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @PutMapping("book")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                                              @Valid @RequestBody Book bookDetails) {
       Book book = bookService.getBookById(bookId);
       bookService.updateBook(book, bookDetails);
       return book;
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @DeleteMapping("book/{id}")
    public void deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null){
           bookService.deleteBook(bookId);
        }
    }


}
