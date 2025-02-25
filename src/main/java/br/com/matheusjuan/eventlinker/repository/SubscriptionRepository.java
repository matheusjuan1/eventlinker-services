package br.com.matheusjuan.eventlinker.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matheusjuan.eventlinker.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

    
}
