package com.github.allanccruz.POC1.api.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private UUID id;

    private String name;

    private String email;

    private String phoneNumber;

    private List<AddressResponseDto> addresses;

}
