package com.github.allanccruz.POC1.api.service;

import com.github.allanccruz.POC1.api.dto.request.AddressRequestDto;
import com.github.allanccruz.POC1.api.dto.request.CustomerRequestDto;
import com.github.allanccruz.POC1.api.dto.request.MainAddressRequestDto;
import com.github.allanccruz.POC1.api.entities.Address;
import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.exception.addressException.AddressMaxLimitException;
import com.github.allanccruz.POC1.api.exception.addressException.AddressNotFoundException;
import com.github.allanccruz.POC1.api.exception.addressException.OnlyAddressDeleteException;
import com.github.allanccruz.POC1.api.exception.customerException.CustomerNotFoundException;
import com.github.allanccruz.POC1.api.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        if (customer.getAddresses().isEmpty()) {
            addressRequestDto.setMainAddress(true);
        } else {
            addressRequestDto.setMainAddress(false);
        }

        if (customer.getAddresses().size() > 5) {
            throw new AddressMaxLimitException();
        }
        return addressRepository.save(mapper.map(addressRequestDto, Address.class));
    }

    public Address findById(UUID addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException(addressId));
    }

    @Transactional
    public void deleteById(UUID addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(addressId));

        if (address.getCustomer().getAddresses().size() <= 1) {
            throw new OnlyAddressDeleteException(addressId);
        }

        addressRepository.deleteById(addressId);
    }

    @Transactional
    public Address update(AddressRequestDto addressRequestDto) {
        if (addressRepository.existsById(addressRequestDto.getId())) {
            return addressRepository.save(mapper.map(addressRequestDto, Address.class));
        } else {
            throw new CustomerNotFoundException(addressRequestDto.getId());
        }
    }

    @Transactional
    public Address updateToMainAddress(MainAddressRequestDto mainAddressRequestDto) {
        Address address = findById(mainAddressRequestDto.getId());

        address.getCustomer().getAddresses()
                .forEach(a -> {
                    a.setMainAddress(false);
                    addressRepository.save(a);
                });

        address.setMainAddress(true);

        return addressRepository.save(address);
    }
}
