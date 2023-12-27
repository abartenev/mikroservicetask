package com.example.microskilltask.controllers;

import com.example.microskilltask.dto.subscribing.subscriberStatus;
import com.example.microskilltask.models.Subscribe;
import com.example.microskilltask.models.Subscriber;
import com.example.microskilltask.repositories.SubscribeRepo;
import com.example.microskilltask.services.SubscribeService;
import com.example.microskilltask.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private SubscriberService subscriberService;
    private SubscribeService subscribeService;

    @Autowired
    public ApiController(SubscriberService subscriberService, SubscribeService subscribeService) {
        this.subscriberService = subscriberService;
        this.subscribeService = subscribeService;
    }

    @PostMapping("/users")
    public ResponseEntity<subscriberStatus> addSubscriber(@RequestBody Subscriber subscriber) {
        return ResponseEntity.ok(subscriberService.createSubscriber(subscriber));
    }

    @PostMapping("/subscribes")
    public void addSubscription(@RequestBody List<Subscribe> subscribes) {
        subscribeService.addSubscription(subscribes);
    }

    @DeleteMapping("/subscribes/{nameSubsribtion}")
    public void delSubscription(@PathVariable String nameSubsribtion) {
        subscribeService.delSubcription(nameSubsribtion);
    }

    @PutMapping("/subscribes/{nameSubsribtion}/{newname}")
    public void updateSubscription(@PathVariable String nameSubsribtion,@PathVariable String newname) {
        subscribeService.updateSubcription(nameSubsribtion,newname);
    }

    @GetMapping("/subscribes")
    public List<Subscribe> addSubscription() {
        return subscribeService.subscribes();
    }
}
