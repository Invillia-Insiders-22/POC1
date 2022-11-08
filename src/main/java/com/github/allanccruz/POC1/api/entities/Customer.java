package com.github.allanccruz.POC1.api.entities;

import com.github.allanccruz.POC1.api.enums.DocumentType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_customer")
public class Customer {

    @org.hibernate.annotations.Type(type="uuid-char")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(nullable = false)
    private String phoneNumber;

//    @Column (nullable = false)
//    private List<Address> addresses;
//
//    @Column(nullable = false)
//    private Address mainAddress;

}