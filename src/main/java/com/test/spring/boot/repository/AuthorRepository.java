package com.test.spring.boot.repository;

import com.test.spring.boot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Long> {

}
