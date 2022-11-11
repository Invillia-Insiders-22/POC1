package com.github.allanccruz.POC1.api.Exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.github.allanccruz.POC1.api.Exception.dto.ErrorMessageDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
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
