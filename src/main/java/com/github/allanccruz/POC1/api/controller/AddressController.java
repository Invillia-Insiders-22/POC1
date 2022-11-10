package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.service.AddressService;
import com.github.allanccruz.POC1.api.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/poc1")
public class AddressController {

    private CustomerService customerService;

    private AddressService addressService;

    @PostMapping(value = "/address/{id}")
    public ResponseEntity<Address> save(@PathVariable UUID id, @RequestBody Address address) {
        Customer customer = customerService.findById(id);
        address.setCustomer(customer);
        customer.getAddresses().add(address);
        return ResponseEntity.status(CREATED).body(addressService.create(address));
    }
}
