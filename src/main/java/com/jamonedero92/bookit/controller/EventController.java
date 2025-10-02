package com.jamonedero92.bookit.controller;

import com.jamonedero92.bookit.dto.EventDTO;
import com.jamonedero92.bookit.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EventController {


    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("events")
    public ResponseEntity<List<EventDTO>> showEvents() {
        List<EventDTO> events = eventService.showAllEvents();
        if (events.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(events);
    }

    @PostMapping("events/register")
    public ResponseEntity<EventDTO> addNewEvent(@RequestBody @Valid EventDTO dto) {
        EventDTO saved = eventService.addNewEvent(dto);

        URI location = URI.create(String.format("/events/%d", saved.getId()));
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("events/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable long id, @RequestBody EventDTO dto) {
        EventDTO saved = eventService.updateEvent(id, dto);
        return ResponseEntity.ok().body(saved);
    }
}
