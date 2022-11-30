package com.github.allanccruz.POC1.api.repository;

import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findByCustomer(Customer customer);
}
