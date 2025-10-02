package com.jamonedero92.bookit.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Booking> bookings;




    public Event() {
    }

    public Event(long id, String title, String description, String place, LocalDateTime dateTime, int capacity) {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
