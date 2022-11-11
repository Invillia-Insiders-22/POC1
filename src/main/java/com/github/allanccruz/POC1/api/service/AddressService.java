package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.Exception.AddressNotFoundException;
import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.AddressRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final ModelMapper mapper;

    private AddressRepository addressRepository;

    @Transactional
    public Address create(AddressRequestDto addressDto) {
        return addressRepository.save(mapper.map(addressDto, Address.class));
    }

    @Transactional
    public void deleteById(UUID addressId) {

        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
            throw new AddressNotFoundException("The address you tried to delete does not exist.");
        }

        List<Address> addresses = findByCustomer(address.get().getCustomer());

        if (addresses.size() <= 1) {
            throw new AddressNotFoundException(" The address you tried" +
                    " to delete is the only address of this client. ");
        }

        addressRepository.deleteById(addressId);

    }

    @Transactional
    public Address findById(UUID addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address Id not found"));

    }

    @Transactional
    List<Address> findByCustomer(Customer customer) {

        return addressRepository.findByCustomer(customer);

    }


}
