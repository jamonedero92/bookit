package com.jamonedero92.bookit.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="event_id")
    private Event event;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Booking() {
    }

    public Booking(long ID, User user, Event event, LocalDateTime createdAt) {
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
