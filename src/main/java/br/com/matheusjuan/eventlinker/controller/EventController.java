package br.com.matheusjuan.eventlinker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusjuan.eventlinker.middleware.EventService;
import br.com.matheusjuan.eventlinker.model.Event;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping("/")
    public Event addNewEvent(@RequestBody Event newEvent) {
        return service.addNewEvent(newEvent);
    }

    @GetMapping("/")
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{prettyName}")
    public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName) {
        Event evt = service.getByPrettyName(prettyName);
        if (evt != null) {
            return ResponseEntity.ok().body(evt);
        }
        return ResponseEntity.notFound().build();
    }
}
