package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.dto.response.CustomerResponseDto;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;

    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CustomerRequestDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(customerService.save(customerDto), CustomerResponseDto.class));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

}
