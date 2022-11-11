package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.Exception.CustomerNotFoundException;
import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Id not found"));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void deleteById(UUID id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.orElseThrow(() -> new CustomerNotFoundException("Customer does not exist!"));
        customerRepository.deleteById(id);
    }

    public Customer update(CustomerRequestDto customerRequestDto) {
        if (existById(customerRequestDto.getId())) {
            return customerRepository.save(mapper.map(customerRequestDto, Customer.class));
        } else {
            throw new CustomerNotFoundException("Customer does not exist!");
        }
    }

    private boolean existById(UUID id) {
        return customerRepository.existsById(id);
    }
}