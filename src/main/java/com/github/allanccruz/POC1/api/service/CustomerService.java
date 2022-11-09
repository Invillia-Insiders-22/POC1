package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer save (Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }
}
