package com.test.spring.boot.repository;

import com.test.spring.boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}