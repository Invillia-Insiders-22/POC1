package com.github.allanccruz.POC1.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    private String city;

    private String neighborhood;

    private String number;

    private String complement;

    private String cep;

}
