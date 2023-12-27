package com.example.microskilltask.repositories;

import com.example.microskilltask.models.Subscribe;
import com.example.microskilltask.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeRepo extends JpaRepository<Subscribe, Integer> {
public List<Subscribe> findByName(String name);
}
