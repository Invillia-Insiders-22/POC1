package com.github.allanccruz.POC1.api.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorMessageDto {
    private Integer status;

    private String message;

    private String path;
}
