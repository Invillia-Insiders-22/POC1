package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.exception.customerException.CustomerNotFoundException;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper mapper;

    @Transactional
    public Customer save(CustomerRequestDto customerDto) {
        return customerRepository.save(mapper.map(customerDto, Customer.class));
    }

    public Customer findById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public void deleteById(UUID id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }

    @Transactional
    public Customer update(CustomerRequestDto customerRequestDto) {
        if (existById(customerRequestDto.getId())) {
            return customerRepository.save(mapper.map(customerRequestDto, Customer.class));
        } else {
            throw new CustomerNotFoundException(customerRequestDto.getId());
        }
    }

    private boolean existById(UUID id) {
        return customerRepository.existsById(id);
    }
}