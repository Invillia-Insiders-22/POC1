package com.github.allanccruz.POC1.api.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.response.AddressResponseDto;
import com.github.allanccruz.POC1.api.service.AddressService;
import com.github.allanccruz.POC1.api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Address Controller")
@RequestMapping(value = "api/poc1/address")
public class AddressController {

    private ModelMapper mapper;

    private AddressService addressService;

    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "Register an address for a customer")
    public ResponseEntity<AddressResponseDto> save(@RequestBody AddressRequestDto addressRequestDto) {
        return ResponseEntity.status(CREATED).body(mapper.map(addressService.create(addressRequestDto), AddressResponseDto.class));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete address by Id")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
