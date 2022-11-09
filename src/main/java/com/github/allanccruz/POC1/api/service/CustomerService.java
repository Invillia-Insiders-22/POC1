package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import java.util.List;
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

    public Customer findById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void deleteById (UUID id) {
        Optional<Customer> courseOptional = customerRepository.findById(id);
        courseOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        customerRepository.deleteById(id);
    }
}