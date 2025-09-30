package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.dto.UserDTO;
import com.jamonedero92.bookit.entity.User;
import com.jamonedero92.bookit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
