package com.test.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable{

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    @JsonManagedReference
    //@JsonBackReference
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