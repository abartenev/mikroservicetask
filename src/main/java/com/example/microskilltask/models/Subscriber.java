package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "subscribers")
@Data
public class Subscriber {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID subs_id;
    @Column
    private String fio;
    @OneToOne()
    private Address addr_id;
}
