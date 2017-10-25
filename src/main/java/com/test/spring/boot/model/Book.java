package com.test.spring.boot.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @SequenceGenerator(name="seg_gen",
            sequenceName="seq_book",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seg_gen")
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private  Author author;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getName(){
        return name;
    }

    public Author getAuthor() {

        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}