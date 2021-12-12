package com.informatorio.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;
import com.informatorio.proyectoFinal.DAO.EventsDAO;
import com.informatorio.proyectoFinal.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventsController {

    @Autowired
    private EventsDAO eventDAO;

    @GetMapping
    public ResponseEntity<List<Event>> getEvent(){
        List<Event> events = eventDAO.findAll();
        return ResponseEntity.ok(events);
    }
    @RequestMapping(value="{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable("eventId") Long eventId){
        Optional<Event> eventById = eventDAO.findById(eventId);
        if(eventById.isPresent()){
            return ResponseEntity.ok(eventById.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event newEvent = eventDAO.save(event);
        return ResponseEntity.ok(newEvent);
    }
    @DeleteMapping(value="{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("eventId") Long eventId){
        eventDAO.deleteById(eventId);
        return ResponseEntity.ok(null);
    }
    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        Optional<Event> updateEvent = eventDAO.findById(event.getId());
        if(updateEvent.isPresent()){
            Event eventUpdate = updateEvent.get();
            eventUpdate.setDetails(event.getDetails());
            eventUpdate.setDateCreation(event.getDateCreation());
            eventUpdate.setDateCloser(event.getDateCloser());
            eventUpdate.setStatus(event.getStatus());
            eventUpdate.setSuscribers(event.getSuscribers());
            eventUpdate.setPrize(event.getPrize());
            eventDAO.save(eventUpdate);
            return ResponseEntity.ok(eventUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
