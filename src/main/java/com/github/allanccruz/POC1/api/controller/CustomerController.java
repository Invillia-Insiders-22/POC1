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
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("api/poc1")
public class CustomerController {

    private final ModelMapper mapper;
    private final CustomerService customerService;

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(mapper.map(customerService.findById(id), CustomerResponseDto.class));
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CustomerRequestDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(customerService.save(customerDto), CustomerResponseDto.class));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.findAll()
                .stream()
                .map(n -> (mapper.map(n, CustomerResponseDto.class)))
                .collect(Collectors.toList()));
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id){
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable("id") UUID id, @RequestBody CustomerRequestDto customerRequestDto){
        customerRequestDto.setId(id);
        Customer customer = customerService.update(customerRequestDto);
        return ResponseEntity.ok().body(mapper.map(customer, CustomerResponseDto.class));
    }
}