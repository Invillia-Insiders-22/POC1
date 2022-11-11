package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.AddressRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public void deleteById(UUID addressId) {

        Optional<Address> address = findById(addressId);

        if (address.isEmpty()) {
            throw new RuntimeException(" the address you tried to delete does not exist. ");
        }

        List<Address> addresses = findByCustomer(address.get().getCustomer());

        if (addresses.size() <= 1) {
            throw new RuntimeException(" the address you tried" +
                    " to delete is the only address of this client. ");
        }

        addressRepository.deleteById(addressId);

    }

    @Transactional
    public Optional<Address> findById(UUID addressId) {

        return addressRepository.findById(addressId);

    }

    @Transactional
    List<Address> findByCustomer(Customer customer) {

        return addressRepository.findByCustomer(customer);

    }


}
