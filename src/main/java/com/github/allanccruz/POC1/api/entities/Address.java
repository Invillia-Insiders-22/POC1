package com.github.allanccruz.POC1.api.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
