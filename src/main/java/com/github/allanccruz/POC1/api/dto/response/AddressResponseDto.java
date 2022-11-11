package com.github.allanccruz.POC1.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {

    private String city;

    private String neighborhood;

    private String addressNumber;

    private String complement;

    private String cep;

    private String id;

}
