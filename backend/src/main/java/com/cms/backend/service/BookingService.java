package com.cms.backend.service;

import com.cms.backend.model.Booking;
import com.cms.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class BookingService {
    
    private final BookingRepository bookingRepository;
    
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    //CREATE

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    //READ

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id){
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByDate(LocalDate date){
        ZonedDateTime startOfDay = date.atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime endOfDay = startOfDay.plusDays(1);

        return bookingRepository.findByBookingDateTimeBetween(startOfDay, endOfDay);
    }

    public List<Booking> getBookingsByClient(String clientName){
        return bookingRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    public List<Booking> getBookingsByEmail(String email){
        return bookingRepository.findByEmail(email);
    }

    //UPDATE

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id)
            .map(existing -> {
                existing.setClientName(updatedBooking.getClientName());
                existing.setEmail(updatedBooking.getEmail());
                existing.setPhone(updatedBooking.getPhone());
                existing.setAddress(updatedBooking.getAddress());
                existing.setBookingDateTime(updatedBooking.getBookingDateTime());
                return bookingRepository.save(existing);
            })
            .orElseThrow(() -> new BookingNotFoundException(id));
    }
    
    //DELETE

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }

    //Error Handling

    public class BookingNotFoundException extends RuntimeException {
        public BookingNotFoundException(Long id){
            super("Booking with ID" + id + "not found");
        }
    }
}


