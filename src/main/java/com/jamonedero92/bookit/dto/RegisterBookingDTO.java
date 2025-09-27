package com.jamonedero92.bookit.dto;

import java.time.LocalDateTime;

public class RegisterBookingDTO {


    private long userId;
    private long eventId;

    public RegisterBookingDTO() {
    }

    public RegisterBookingDTO(long userId, long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
}
