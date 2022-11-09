package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Transactional
    public Customer save (CustomerRequestDto customerDto) {
        return customerRepository.save(mapper.map(customerDto, Customer.class));
    }

    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }
}
