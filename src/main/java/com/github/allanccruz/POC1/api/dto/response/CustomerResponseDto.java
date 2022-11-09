package com.github.allanccruz.POC1.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String name;

    private String email;

    private String phoneNumber;

}
