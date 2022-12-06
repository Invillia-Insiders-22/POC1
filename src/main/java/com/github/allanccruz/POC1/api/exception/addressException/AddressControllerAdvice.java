package com.github.allanccruz.POC1.api.exception.addressException;

import com.github.allanccruz.POC1.api.exception.dto.ErrorMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class AddressControllerAdvice {
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> idNotFound(AddressNotFoundException exception,
                                                      HttpServletRequest request) {
        ErrorMessageDto errorDto = new ErrorMessageDto(
                NOT_FOUND.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(AddressMaxLimitException.class)
    public ResponseEntity<ErrorMessageDto> addressMaxLimit(AddressMaxLimitException exception,
                                                           HttpServletRequest request) {
        ErrorMessageDto errorDto = new ErrorMessageDto(
                CONFLICT.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(CONFLICT).body(errorDto);
    }

    @ExceptionHandler(OnlyAddressDeleteException.class)
    public ResponseEntity<ErrorMessageDto> onlyAddressDelete(OnlyAddressDeleteException exception,
                                                             HttpServletRequest request) {
        var errorDto = ErrorMessageDto.builder()
                .status(CONFLICT.value())
                .message(exception.getMessage())
                .path(request.getRequestURI()).build();

        return ResponseEntity.status(CONFLICT).body(errorDto);
    }
}
