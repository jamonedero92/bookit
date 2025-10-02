package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.dto.BookingDTO;
import com.jamonedero92.bookit.dto.RegisterBookingDTO;
import com.jamonedero92.bookit.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping("bookings/register")
    public ResponseEntity<BookingDTO> registerNewBooking(@RequestBody @Valid RegisterBookingDTO registerBookingDTO){
        BookingDTO dto=bookingService.registerBooking(registerBookingDTO);
        return ResponseEntity.ok(dto);
    }
}
