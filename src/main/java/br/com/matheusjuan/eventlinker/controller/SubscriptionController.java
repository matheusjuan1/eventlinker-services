package br.com.matheusjuan.eventlinker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusjuan.eventlinker.middleware.SubscriptionService;
import br.com.matheusjuan.eventlinker.model.Subscription;
import br.com.matheusjuan.eventlinker.model.User;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/{prettyName}")
    public ResponseEntity<Subscription> createSubscription(@PathVariable String prettyName, @RequestBody User subcriber) {
        Subscription res = service.createNewSubscription(prettyName, subcriber);
        if (res != null) {
            return ResponseEntity.ok().body(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
