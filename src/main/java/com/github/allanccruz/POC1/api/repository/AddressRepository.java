package com.github.allanccruz.POC1.api.repository;

import com.github.allanccruz.POC1.api.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

}
