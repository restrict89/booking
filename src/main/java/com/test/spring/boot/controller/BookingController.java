package com.test.spring.boot.controller;

import java.util.List;

import com.test.spring.boot.model.Author;
import com.test.spring.boot.model.Book;
import com.test.spring.boot.model.Booking;
import com.test.spring.boot.repository.BookRepository;
import com.test.spring.boot.service.AuthorService;
import com.test.spring.boot.service.BookingService;
import com.test.spring.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;


    @PostMapping("/add")
    public void addBook(@RequestParam("book_id") Long book_id, @RequestParam("user_id")  Long user_id) {
        bookingService.addReserv(book_id, user_id);
    }

    @DeleteMapping("reserv/{id}")
    public void deleteBook(@PathVariable(value = "id") Long reservId) {
        Booking reserv = bookingService.getReservById(reservId);
        if (reserv != null){
            bookingService.deleteReserv(reservId);
        }
    }

    @GetMapping("/allReserv")
    public List<Booking> getAllReserv() {

        return bookingService.getReservs();
    }


}
