package com.test.spring.boot.service;

import com.test.spring.boot.model.Book;
import com.test.spring.boot.model.Booking;

import java.util.Date;
import java.util.List;

public interface IBookingService {
    Booking getReservById( Long id);
    void addReserv(Long bookId, Long userId);
    void deleteReserv(long reservID);
    List<Booking> getReservs();
    List<Book> getUserReservBooks(Long userId);

}
