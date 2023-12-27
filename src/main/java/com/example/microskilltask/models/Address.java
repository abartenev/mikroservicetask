package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SoftDelete;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "addresses")
@Data
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID addr_id;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String flat;


    public Address() {
    }

    public Address(String city, String street, String flat) {
        this.city = city;
        this.street = street;
        this.flat = flat;
    }
}
