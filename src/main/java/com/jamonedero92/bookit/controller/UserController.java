package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.dto.BookingDTO;
import com.jamonedero92.bookit.dto.RegisterUserDTO;
import com.jamonedero92.bookit.dto.UserDTO;
import com.jamonedero92.bookit.entity.User;
import com.jamonedero92.bookit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> showUsers() {
        List<UserDTO> usersDto = userService.getAllUsers();
        if (usersDto.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(usersDto);
    }

    @GetMapping("users/by-email")
    public ResponseEntity<UserDTO> showUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDTO> showUserById(@PathVariable long id){
       return ResponseEntity.ok(userService.findUserById(id)) ;
    }

    @GetMapping("users/{id}/bookings")
    public ResponseEntity<List<BookingDTO>> showUserBookings(@PathVariable long id){
        List<BookingDTO> bookingDTOS=userService.getBookingsByUserId(id);
        if(bookingDTOS.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bookingDTOS);
    }

    @PostMapping("users/register")
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody @Valid RegisterUserDTO newUserDto){
       UserDTO dto= userService.addNewUser(newUserDto);
        URI location=URI.create(String.format("users/%d",dto.getId()));
       return ResponseEntity.created(location).body(dto);
    }



}
