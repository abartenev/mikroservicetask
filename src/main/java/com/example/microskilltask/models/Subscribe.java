package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "subscribes")
@Data
public class Subscribe {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID sub_id;
    @Column
    private String name;
    @Column
    private String description;
}
