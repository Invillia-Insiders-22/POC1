package com.github.allanccruz.POC1.api.exception.customerException;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(UUID id) {
        super(errorMessage(id));
    }

    private static String errorMessage(UUID id) {
        return String.format("The following customer ID '%s' could not be found", id);
    }
}
