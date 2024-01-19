package com.example.microskilltask.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "subscribers",uniqueConstraints = {@UniqueConstraint(name = "subscribers_addr_uc",columnNames = {"addr_id"})})
@Data
public class Subscriber {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID subs_id;
    @Column
    @Check(name = "subscribers_fio_chk", constraints = "FIO IS NOT NULL")
    private String fio;
    @OneToOne()
    @JoinColumn(name = "addr_id", referencedColumnName = "addr_id", foreignKey = @ForeignKey(name = "subscribers_address_fk", value = ConstraintMode.CONSTRAINT))
    private Address addr_id;
}
