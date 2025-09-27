package com.jamonedero92.bookit.repository;

import com.jamonedero92.bookit.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
     List<Booking> findByUserId(String userId);
     List<Booking> findByEventId(String eventId);
}
