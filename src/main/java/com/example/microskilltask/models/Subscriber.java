package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;
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
    @Check(name = "subscribers_fio_chk", constraints = "FIO IS NOT NULL")
    private String fio;
    @OneToOne(cascade = CascadeType.ALL)
    private Address addr_id;
}
