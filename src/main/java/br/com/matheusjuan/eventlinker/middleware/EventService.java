package br.com.matheusjuan.eventlinker.middleware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheusjuan.eventlinker.model.Event;
import br.com.matheusjuan.eventlinker.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addNewEvent(Event event) {
        // gerando o pretty name
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event getByPrettyName(String prettyName) {
        return eventRepository.findByPrettyName(prettyName);
    }
}
