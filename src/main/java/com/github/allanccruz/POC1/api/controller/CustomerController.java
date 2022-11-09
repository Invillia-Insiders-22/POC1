package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.dto.CustomerDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/poc1")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers/{id}")
    public List<Customer> findById(@PathVariable UUID id){
        return customerService.findById(id);
    }

    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

}
