package com.jamonedero92.bookit.DTO;

import com.jamonedero92.bookit.entity.Booking;
import com.jamonedero92.bookit.entity.Role;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public class UserDTO {

    private long Id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(long id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
