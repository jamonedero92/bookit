package com.jamonedero92.bookit.DTO;


import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class RegisterEventDTO {

    @NotBlank(message = "The title of the event can't be empty")
    @Size(min = 3, max = 50, message = "The title must be between 3 to 50 characters")
    private String title;

    @NotBlank(message = "The description of the event can't be empty")
    @Size(min = 3, max = 250, message = "The description must be between 3 to 250 characters")
    private String description;

    @NotBlank(message = "The place of the event can't be empty")
    @Size(min = 3, max = 50, message = "The place must be between 3 to 250 characters")
    private String place;

    @NotNull(message = "The date cant be null")
    @Future(message = "The date must be in the future")
    private LocalDateTime createdAt;

    @Min(value = 1, message = "The capacity of the event must be larger than 0")
    @NotNull(message = "The capacity of the event can't be null")
    private Integer capacity;

    public RegisterEventDTO() {
    }

    public RegisterEventDTO(String title, String description, String place, LocalDateTime createdAt, Integer capacity) {
        this.title = title;
        this.description = description;
        this.place = place;
        this.createdAt = createdAt;
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
