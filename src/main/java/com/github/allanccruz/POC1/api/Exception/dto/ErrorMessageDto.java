package com.github.allanccruz.POC1.api.Exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessageDto {
    private Integer status;

    private String message;

    private String path;
}
