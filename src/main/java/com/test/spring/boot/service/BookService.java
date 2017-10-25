package com.test.spring.boot.service;

import com.test.spring.boot.model.Book;

import java.util.List;

import com.test.spring.boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
       return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long bookId) {
        Book book = bookRepository.findOne(bookId);
        return book;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book, Book bookDetails) {
        book.setAuthor(bookDetails.getAuthor());
        book.setName(bookDetails.getName());
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(long bookId) {
        bookRepository.delete(bookId);
    }
}
