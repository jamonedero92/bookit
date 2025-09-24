package com.jamonedero92.bookit.service;

import com.jamonedero92.bookit.DTO.EventDTO;
import com.jamonedero92.bookit.entity.Event;
import com.jamonedero92.bookit.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public EventDTO eventToDto(Event e) {
        EventDTO dto = new EventDTO();
        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setPlace(e.getPlace());
        dto.setDate_time(e.getDate_time());
        dto.setCapacity(e.getCapacity());
        return dto;
    }

    public List<EventDTO> showAllEvents() {
        return eventRepository.findAll().stream().map(this::eventToDto).toList();
    }

    public EventDTO addNewEvent(EventDTO dto) {
        Event event = new Event();
        //  event.setId(dto.getId());
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setPlace(dto.getPlace());
        event.setDate_time(dto.getDate_time());
        event.setCapacity(dto.getCapacity());

        Event saved = eventRepository.save(event);

        EventDTO result = new EventDTO();
        result.setId(saved.getId());
        result.setTitle(saved.getTitle());
        result.setDescription(saved.getDescription());
        result.setPlace(saved.getPlace());
        result.setDate_time(saved.getDate_time());
        result.setCapacity(saved.getCapacity());

        return result;
    }

    public void deleteEvent(long id) {

        if (!eventRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found.");
        eventRepository.deleteById(id);
    }

    public EventDTO updateEvent(long id, EventDTO dto) {

        Event e = eventRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setPlace(dto.getPlace());
        e.setDate_time(dto.getDate_time());
        e.setCapacity(dto.getCapacity());

        Event saved = eventRepository.save(e);

        EventDTO result = new EventDTO();
        result.setId(saved.getId());
        result.setTitle(saved.getTitle());
        result.setDescription(saved.getDescription());
        result.setPlace(saved.getPlace());
        result.setDate_time(saved.getDate_time());
        result.setCapacity(saved.getCapacity());

        return result;
    }

}
