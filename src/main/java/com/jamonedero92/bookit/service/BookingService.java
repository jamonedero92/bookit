package com.jamonedero92.bookit.service;

import com.jamonedero92.bookit.dto.BookingDTO;
import com.jamonedero92.bookit.dto.RegisterBookingDTO;
import com.jamonedero92.bookit.entity.Booking;
import com.jamonedero92.bookit.entity.Event;
import com.jamonedero92.bookit.entity.User;
import com.jamonedero92.bookit.repository.BookingRepository;
import com.jamonedero92.bookit.repository.EventRepository;
import com.jamonedero92.bookit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }


    public BookingDTO registerBooking(RegisterBookingDTO registerBookingDTO) {


        User user = userRepository.findById(registerBookingDTO.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
        Event event = eventRepository.findById(registerBookingDTO.getEventId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found."));

        if (event.getBookings().size() >= event.getCapacity())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The event is already full.");

        if (bookingRepository.existsByUserIdAndEventId(user.getId(), event.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This event is already booked");

        Booking booking = new Booking();
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUser(user);
        booking.setEvent(event);

        Booking saved = bookingRepository.save(booking);

        return bookingToDto(saved);
    }

    public void deleteBooking(long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found."));
        bookingRepository.deleteById(booking.getID());
    }

    public BookingDTO getBookingById(long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found."));

        return bookingToDto(booking);
    }

    private BookingDTO bookingToDto(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setID(booking.getID());
        dto.setCreatedAt(booking.getCreatedAt());
        dto.setUserId(booking.getUser().getId());
        dto.setUserName(booking.getUser().getName());
        dto.setEventId(booking.getEvent().getId());
        dto.setEventTitle(booking.getEvent().getTitle());
        return dto;
    }
}
