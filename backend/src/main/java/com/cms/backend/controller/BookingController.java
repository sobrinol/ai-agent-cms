package com.cms.backend.controller;

import com.cms.backend.model.Booking;
import com.cms.backend.service.BookingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173") 
public class BookingController {

    private final BookingService bookingService;
    
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //POST

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    //GET

    @GetMapping
    public List<Booking> getBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-date")
    public List<Booking> getBookingsByDate(@RequestParam LocalDate date){
        return bookingService.getBookingsByDate(date);
    }

    @GetMapping("/by-client")
    public List<Booking> getBookingsByClient(@RequestParam String name){
        return bookingService.getBookingsByClient(name);
    }

    @GetMapping("by-email")
    public List<Booking> getBookingsByEmail(@RequestParam String email){
        return bookingService.getBookingsByEmail(email);
    }



    //PUT or PATCH

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking){
        try{
            return ResponseEntity.ok(bookingService.updateBooking(id, updatedBooking));
        } catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
