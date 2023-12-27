package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "subscribeinfo")
@Data
public class SubscribeInfo {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Subscribe sub_id;
    @ManyToOne
    private Subscriber subs_id;
}
