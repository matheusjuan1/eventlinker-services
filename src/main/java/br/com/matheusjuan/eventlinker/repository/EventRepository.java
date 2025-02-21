package br.com.matheusjuan.eventlinker.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matheusjuan.eventlinker.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

    public Event findByPrettyName(String prettyName);
}
