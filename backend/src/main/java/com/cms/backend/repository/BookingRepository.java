package com.cms.backend.repository;

import com.cms.backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingDateTimeBetween(ZonedDateTime start, ZonedDateTime end);
    List<Booking> findByClientNameContainingIgnoreCase(String clientName);
    List<Booking> findByEmail(String email);
}