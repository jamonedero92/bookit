package com.jamonedero92.bookit.repository;

import com.jamonedero92.bookit.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
