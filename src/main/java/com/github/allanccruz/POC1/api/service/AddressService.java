package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.Exception.AddressMaxLimitException;
import com.github.allanccruz.POC1.api.Exception.AddressNotFoundException;
import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {

    private final ModelMapper mapper;

    private final AddressRepository addressRepository;

    private final CustomerService customerService;

    @Transactional
    public Address create(AddressRequestDto addressRequestDto) {
        Customer customer = customerService.findById(addressRequestDto.getCustomerDto().getId());
        addressRequestDto.setCustomerDto(mapper.map(customer, CustomerRequestDto.class));
        if(customer.getAddresses().size() > 5){
            throw new AddressMaxLimitException("Maximum number of registered addresses reached");
        }
        return addressRepository.save(mapper.map(addressRequestDto, Address.class));
    }

    public void deleteById(UUID addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
            throw new AddressNotFoundException("The address you tried to delete does not exist.");
        }

        List<Address> addresses = findByCustomer(address.get().getCustomer());

        if (addresses.size() <= 1) {
            throw new AddressNotFoundException("The address you tried to delete is the only address of this client.");
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
