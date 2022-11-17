package com.github.allanccruz.POC1.api.dto.request;

import com.github.allanccruz.POC1.api.enums.DocumentType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private UUID id;

    private String name;

    private String email;

    private String document;

    private DocumentType documentType;

    private String phoneNumber;

}
