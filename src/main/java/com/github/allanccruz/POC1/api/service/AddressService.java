package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public Address create(Address address) {
        return addressRepository.save(address);
    }
}
