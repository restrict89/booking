package com.test.spring.boot.service;

import com.test.spring.boot.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(long authorId);
    void addAuthor(Author author);
    void updateAuthor(Author author, Author authorDetails);
    void deleteAuthor(long authorId);
}
