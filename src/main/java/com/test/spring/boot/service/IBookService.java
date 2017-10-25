package com.test.spring.boot.service;

import java.util.List;
import com.test.spring.boot.model.Book;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(long bookId);
    void addBook(Book book);
    void updateBook(Book book, Book bookDetails);
    void deleteBook(long bookId);
}