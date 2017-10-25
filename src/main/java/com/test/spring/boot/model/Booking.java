package com.test.spring.boot.model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @SequenceGenerator(name="seg_gen",
            sequenceName="seq_booking",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seg_gen")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_RESERV")
    private Date dateReserv;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID", unique=true)
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {

        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Date getDateReserv() {
        return dateReserv;
    }

    public void setDateReserv(Date dateReserv) {
        this.dateReserv = dateReserv;
    }
}
