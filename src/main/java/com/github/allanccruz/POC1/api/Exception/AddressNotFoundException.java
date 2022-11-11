package com.github.allanccruz.POC1.api.Exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
