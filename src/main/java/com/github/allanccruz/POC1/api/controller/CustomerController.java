package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.dto.CustomerDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("api/poc1")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

}
