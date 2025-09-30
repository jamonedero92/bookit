package com.jamonedero92.bookit.service;

import com.jamonedero92.bookit.dto.BookingDTO;
import com.jamonedero92.bookit.dto.RegisterUserDTO;
import com.jamonedero92.bookit.dto.UserDTO;
import com.jamonedero92.bookit.entity.Booking;
import com.jamonedero92.bookit.entity.Role;
import com.jamonedero92.bookit.entity.User;
import com.jamonedero92.bookit.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::userToDto).toList();

    }

    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
        return userToDto(user);
    }

    private UserDTO userToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public UserDTO addNewUser(RegisterUserDTO newUserDto) {

        if (userRepository.findByEmail(newUserDto.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already registered");

        User newUser = new User();
        newUser.setEmail(newUserDto.getEmail());
        newUser.setName(newUserDto.getName());
        newUser.setPassword(newUserDto.getPassword());
        newUser.setRoles(Set.of(Role.ROLE_USER));

        return userToDto(userRepository.save(newUser));
    }

    public UserDTO findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
        return userToDto(user);
    }

    public List<BookingDTO> getBookingsByUserId(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
        return user.getBookings().stream().map(this::bookingToDto).toList();
    }

    private BookingDTO bookingToDto(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setUserId(booking.getID());
        dto.setCreatedAt(booking.getCreatedAt());
        dto.setUserId(booking.getUser().getId());
        dto.setUserName(booking.getUser().getName());
        dto.setEventId(booking.getEvent().getId());
        dto.setEventTitle(booking.getEvent().getTitle());
        return dto;
    }
}
