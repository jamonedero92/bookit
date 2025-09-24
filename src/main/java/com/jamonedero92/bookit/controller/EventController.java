package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.repository.EventRepository;
import com.jamonedero92.bookit.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("events")
    public void showEvents() {
        eventService.showEvents();
    }
}
