package com.github.allanccruz.POC1.api.dto.request;

import com.github.allanccruz.POC1.api.entities.Customer;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {

    private UUID id;

    private String city;

    private String neighborhood;

    private String addressNumber;

    private String complement;

    private String cep;

    private Customer customer;

}
