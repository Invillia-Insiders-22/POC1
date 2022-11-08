package com.github.allanccruz.POC1.api.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String city;

    private String neighborhood;

    private String number;

    private String complement;

    private String cep;

}
