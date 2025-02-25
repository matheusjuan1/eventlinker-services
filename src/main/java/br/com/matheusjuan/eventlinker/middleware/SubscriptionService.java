package br.com.matheusjuan.eventlinker.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheusjuan.eventlinker.error.EventNotFoundException;
import br.com.matheusjuan.eventlinker.model.Event;
import br.com.matheusjuan.eventlinker.model.Subscription;
import br.com.matheusjuan.eventlinker.model.User;
import br.com.matheusjuan.eventlinker.repository.EventRepository;
import br.com.matheusjuan.eventlinker.repository.SubscriptionRepository;
import br.com.matheusjuan.eventlinker.repository.UserRepository;

@Service
public class SubscriptionService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createNewSubscription(String eventName, User user) {

        // recuperar evento pelo nome
        Event event = eventRepository.findByPrettyName(eventName);

        if (event == null) {
            throw new EventNotFoundException("Evento " + eventName + " não existe");
        }

        User userRec = userRepository.findByEmail(user.getEmail());

        if (userRec == null) {
            // Adiciona usuário
            user = userRepository.save(user);
        }

        Subscription subs = new Subscription();
        subs.setEvent(event);
        subs.setSubscriber(userRec);

        Subscription res = subscriptionRepository.save(subs);

        return res;
    }
}
