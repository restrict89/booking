package com.test.spring.boot.service;

import com.test.spring.boot.model.Book;
import com.test.spring.boot.model.Booking;
import com.test.spring.boot.model.User;
import com.test.spring.boot.repository.BookRepository;
import com.test.spring.boot.repository.BookingRepository;
import com.test.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    BookingRepository bookingRepsitory;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @Override
    public Booking getReservById(Long id){
        Booking reserv = bookingRepsitory.findOne(id);
        return reserv;
    }

    @Override
    public void addReserv(Long bookId, Long userId) {
        Booking reserv = new Booking();
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);

        if((user != null) && (book != null)) {
            reserv.setBook(book);
            reserv.setUser(user);
            reserv.setDateReserv(new Date());
            bookingRepsitory.save(reserv);
        }
    }

    @Override
    @Transactional
    public void deleteReserv(long reservID) {
        bookingRepsitory.delete(reservID);
    }

    @Override
    public List<Booking> getReservs() {
       return bookingRepsitory.findAll();
    }

    @Override
    public List<Book> getUserReservBooks(Long userId) {
        return null;
    }
}
