package com.cms.backend.service;

import com.cms.backend.model.Booking;
import com.cms.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    
    private final BookingRepository bookingRepository;
    
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // You can add update, delete, findById, etc. here if needed
}
