package com.jamonedero92.bookit.dto;


import java.time.LocalDateTime;

public class EventDTO {
    private long Id;
    private String title;
    private String description;
    private String place;
    private LocalDateTime dateTime;
    private Integer capacity;

    public EventDTO() {
    }

    public EventDTO(long id, String title, String description, String place, LocalDateTime dateTime, Integer capacity) {
        Id = id;
        this.title = title;
        this.description = description;
        this.place = place;
        this.dateTime = dateTime;
        this.capacity = capacity;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
