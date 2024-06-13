package com.gymz.project_2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Booking;
import com.gymz.project_2.domain.Course;
import com.gymz.project_2.domain.Session;
import com.gymz.project_2.repository.BookingRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking handleSaveBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking() {
        return this.bookingRepository.findAll();
    }

}
