package com.test.spring.boot.controller;

import com.test.spring.boot.model.Author;
import com.test.spring.boot.model.Book;
import com.test.spring.boot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("/api/authors")
    public class AuthorController {

        @Autowired
        AuthorService authorService;

        @GetMapping("/author/{id}")
        public Author getAuthorById(@PathVariable(value = "id") Long authorId) {
            Author author = authorService.getAuthorById(authorId);
            return author;
        }

        @GetMapping("/author/{id}/allBooks")
        public List<Book> getAuthorBooks(@PathVariable(value = "id") Long authorId) {
            Author author = authorService.getAuthorById(authorId);
            return author.getBooks();
        }

        @GetMapping("/allAuthors")
        public List<Author> getAllAuthors() {

            return authorService.getAllAuthors();
        }


        @PreAuthorize("hasAuthority('LIBRARIAN')")
        @PostMapping("/add")
        public void addAuthor(@RequestParam("name") String name) {
            Author author = new Author();
            author.setName(name);
            authorService.addAuthor(author);

        }

        @PreAuthorize("hasAuthority('LIBRARIAN')")
        @PutMapping("author")
        public Author updateAuthor(@PathVariable(value = "id") Long authorId,
                                   @Valid @RequestBody Author authorDetails) {
            Author author = authorService.getAuthorById(authorId);
            authorService.updateAuthor(author, authorDetails);
            return author;
        }

        @PreAuthorize("hasAuthority('LIBRARIAN')")
        @DeleteMapping("author/{id}")
        public void deleteAuthor(@PathVariable(value = "id") Long authorId) {
            Author author = authorService.getAuthorById(authorId);
            if (author != null) {
                authorService.deleteAuthor(authorId);
            }
        }

    }
