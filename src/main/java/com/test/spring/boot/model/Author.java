package com.test.spring.boot.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
public class Author {



    @Id
    @Column(name = "AUTHOR_ID")
    @SequenceGenerator(name="seg_gen",
            sequenceName="seq_author",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seg_gen")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(orphanRemoval=true, fetch = FetchType.LAZY,mappedBy="author")
    private  List<Book> books;


//    public Long getId() {
//
//        return id;
//    }
//
//    public void setId(Long id) {
//
//        this.id = id;
//    }


    public String getName(){
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Book> getBooks() {

        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
