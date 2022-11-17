package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.dto.response.AddressResponseDto;
import com.github.allanccruz.POC1.api.dto.response.CustomerResponseDto;
import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Customer Controller")
@RequestMapping("api/poc1/customers")
public class CustomerController {

    private final ModelMapper mapper;

    private final CustomerService customerService;


    @GetMapping(value = "/{id}")
    @Operation(summary = "Get customer by Id")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(mapper.map(customerService.findById(id), CustomerResponseDto.class));
    }

    @PostMapping
    @Operation(summary = "Register customer")
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CustomerRequestDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(customerService.save(customerDto), CustomerResponseDto.class));
    }

    @GetMapping
    @Operation(summary = "Get all customers registers")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.findAll()
                .stream()
                .map(n -> (mapper.map(n, CustomerResponseDto.class)))
                .collect(Collectors.toList()));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete customer by Id")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update customer by Id")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable("id") UUID id, @RequestBody CustomerRequestDto customerRequestDto) {
        customerRequestDto.setId(id);
        Customer customer = customerService.update(customerRequestDto);
        return ResponseEntity.ok().body(mapper.map(customer, CustomerResponseDto.class));
    }

    @GetMapping(value = "/address/{id}")
    @Operation(summary = "Get all addresses of a specific customer")
    public ResponseEntity<List<AddressResponseDto>> getAllAddressByCustomer(@PathVariable UUID id) {
        Customer customer = customerService.findById(id);
        List<Address> addressList = customer.getAddresses();
        return ResponseEntity.ok().body(addressList
                .stream().map(address -> mapper.map(address, AddressResponseDto.class))
                .collect(Collectors.toList()));
    }
}