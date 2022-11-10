package com.github.allanccruz.POC1.api.dto.response;

import com.github.allanccruz.POC1.api.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String name;

    private String email;

    private String phoneNumber;

    protected List<Address> addresses;
}
