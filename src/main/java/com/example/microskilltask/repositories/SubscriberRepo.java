package com.example.microskilltask.repositories;

import com.example.microskilltask.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber,Integer> {

List<Subscriber> findByFio(String fio);
}
