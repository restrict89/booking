package com.test.spring.boot.service;

import com.test.spring.boot.model.Author;
import com.test.spring.boot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(long authorId) {
        Author author = authorRepository.findOne(authorId);
        return author;
    }

    @Override
   // @Secured("LIBRARIAN") //@PreAuthorize("hasRole('LIBRARIAN')")
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Author author, Author authorDetails) {
        author.setName(authorDetails.getName());
        authorRepository.save(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(long authorId) {
        authorRepository.delete(authorId);
    }
}
