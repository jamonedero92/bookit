package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.dto.BookingDTO;
import com.jamonedero92.bookit.dto.RegisterBookingDTO;
import com.jamonedero92.bookit.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("bookings/{id}")
    public ResponseEntity<BookingDTO> retrieveBookingById(@PathVariable long id) {
        BookingDTO dto = bookingService.getBookingById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("bookings/register")
    public ResponseEntity<BookingDTO> registerNewBooking(@RequestBody @Valid RegisterBookingDTO registerBookingDTO) {
        BookingDTO dto = bookingService.registerBooking(registerBookingDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
