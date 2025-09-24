package com.jamonedero92.bookit.service;

import com.jamonedero92.bookit.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public void showEvents(){
        eventRepository.findAll();
    }


}
