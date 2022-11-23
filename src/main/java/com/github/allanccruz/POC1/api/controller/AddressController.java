package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.response.AddressResponseDto;
import com.github.allanccruz.POC1.api.service.AddressService;
import com.github.allanccruz.POC1.api.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressResponseDto> update(@PathVariable UUID id, @RequestBody AddressRequestDto addressRequestDto) {
        addressRequestDto.setId(id);
        addressService.update(addressRequestDto);
        return ResponseEntity.ok().body(mapper.map(addressService.findById(id), AddressResponseDto.class));
    }
}
