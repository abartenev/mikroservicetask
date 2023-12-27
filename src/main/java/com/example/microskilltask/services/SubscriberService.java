package com.example.microskilltask.services;

import com.example.microskilltask.dto.subscribing.subscriberStatus;
import com.example.microskilltask.models.Address;
import com.example.microskilltask.models.Subscriber;
import com.example.microskilltask.repositories.AddressRepo;
import com.example.microskilltask.repositories.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepo subscriberRepo;
    @Autowired
    private AddressRepo addressRepo;
    public subscriberStatus createSubscriber(Subscriber subscriber) {
        Address address = addressRepo.save(subscriber.getAddr_id());
        subscriber.setAddr_id(address);
        List<Subscriber> subscribers = subscriberRepo.findByFio(subscriber.getFio());
        if (subscribers.size() > 0) {
            return new subscriberStatus(false, String.format("Пользователь %s уже существует", subscribers.get(0).getFio()));
        }
        subscriber = subscriberRepo.save(subscriber);
        return new subscriberStatus(true, String.format("Пользователь %s сохранен в базу", subscriber.getFio()));
    }
}
