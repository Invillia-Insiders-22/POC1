package com.github.allanccruz.POC1.api.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    protected List<AddressResponseDto> addresses;

    private String name;

    private String email;

    private String phoneNumber;

    private String id;
}
