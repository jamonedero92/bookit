package com.jamonedero92.bookit.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {

    @NotBlank(message = "The name of the user can't be empty")
    @Size(min = 3, max = 50, message = "The name must be between 3 to 50 characters")
    private String name;

    @Email(message = "The email must have the right format")
    @NotBlank(message = "The email of the user can't be empty")
    private String email;

    @NotBlank(message = "The password of the user can't be empty")
    @Min(value = 8,message = "The password must have at least 8 characters")
    private String password;


    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
