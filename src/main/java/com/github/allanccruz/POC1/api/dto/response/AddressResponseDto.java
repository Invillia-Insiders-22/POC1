package com.github.allanccruz.POC1.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {

    private UUID id;

    private String city;

    private String neighborhood;

    private String addressNumber;

    private String complement;

    private String cep;

    private Boolean mainAddress;

}
