package com.github.allanccruz.POC1.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAddressRequestDto {

    private UUID id;

    private CustomerRequestDto customerDto;

}
