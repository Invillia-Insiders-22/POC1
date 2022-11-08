package com.github.allanccruz.POC1.api.entities;

import com.github.allanccruz.POC1.api.enums.DocumentType;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private String phoneNumber;

//    @Column (nullable = false)
//    private List<Address> addresses;
//
//    @Column(nullable = false)
//    private Address mainAddress;

}