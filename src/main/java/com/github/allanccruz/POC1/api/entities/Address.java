package com.github.allanccruz.POC1.api.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //  private Boolean mainAddress;
}
