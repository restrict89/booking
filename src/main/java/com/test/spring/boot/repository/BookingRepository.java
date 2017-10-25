package com.test.spring.boot.repository;


import com.test.spring.boot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Long> {

}
