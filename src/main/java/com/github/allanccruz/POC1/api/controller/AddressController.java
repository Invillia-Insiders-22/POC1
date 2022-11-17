package com.github.allanccruz.POC1.api.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.response.AddressResponseDto;
import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.AddressService;
import com.github.allanccruz.POC1.api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Address Controller")
@RequestMapping(value = "api/poc1")
public class AddressController {

    private final ModelMapper mapper;

    private final AddressService addressService;

    private final CustomerService customerService;

    @PostMapping(value = "/address/{id}")
    @Operation(summary = "Register an address for a customer")
    public ResponseEntity<AddressResponseDto> save(@PathVariable UUID id, @RequestBody AddressRequestDto addressRequestDto) {
        Customer customer = customerService.findById(id);
        addressRequestDto.setCustomer(customer);
        customer.getAddresses().add(mapper.map(addressRequestDto, Address.class));
        return ResponseEntity.status(CREATED).body(mapper.map(addressService.create(addressRequestDto), AddressResponseDto.class));
    }

    @DeleteMapping(value = "/address/{id}")
    @Operation(summary = "Delete address by Id")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
