package com.github.allanccruz.POC1.api.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Data
public class Address {

    @Type(type = "uuid-char")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false, name = "address_number")
    private String addressNumber;

    @Column
    private String complement;

    @Column(nullable = false)
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "main_address")
    private Boolean mainAddress;

}
