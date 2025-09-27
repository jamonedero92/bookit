package com.jamonedero92.bookit.DTO;

import com.jamonedero92.bookit.entity.Event;
import com.jamonedero92.bookit.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class BookingDTO {

    private long ID;
    private User user;
    private Event event;
    private LocalDateTime createdAt;

    public BookingDTO() {
    }

    public BookingDTO(long ID, User user, Event event, LocalDateTime createdAt) {
        this.ID = ID;
        this.user = user;
        this.event = event;
        this.createdAt = createdAt;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
