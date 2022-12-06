package com.github.allanccruz.POC1.api.exception.customerException;

import com.github.allanccruz.POC1.api.exception.dto.ErrorMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class CustomerControllerAdvice {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> IdNotFound(CustomerNotFoundException exception, HttpServletRequest request) {
        ErrorMessageDto errorDto = new ErrorMessageDto(
                NOT_FOUND.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(NOT_FOUND).body(errorDto);
    }
}
