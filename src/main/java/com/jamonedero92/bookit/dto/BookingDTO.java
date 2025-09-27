package com.jamonedero92.bookit.dto;

import java.time.LocalDateTime;

public class BookingDTO {

    private long ID;
    private long userId;
    private String userName;
    private long eventId;
    private String eventTitle;
    private LocalDateTime createdAt;

    public BookingDTO() {
    }

    public BookingDTO(long ID, long userId, String userName, long eventId, String eventTitle, LocalDateTime createdAt) {
        this.ID = ID;
        this.userId = userId;
        this.userName = userName;
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.createdAt = createdAt;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
