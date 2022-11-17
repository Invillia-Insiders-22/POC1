package com.github.allanccruz.POC1.api.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.response.AddressResponseDto;
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
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<AddressResponseDto> save(@PathVariable UUID id, @RequestBody Address address) {
        Customer customer = customerService.findById(id);
        address.setCustomer(customer);
        customer.getAddresses().add(address);
        return ResponseEntity.status(CREATED).body(mapper.map(addressService.create(address), AddressResponseDto.class));
    }

    @DeleteMapping(value = "/address/{id}")
    @Operation(summary = "Delete a customer address")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {

        addressService.deleteById(id);

    }
}
