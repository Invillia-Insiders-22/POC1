package com.github.allanccruz.POC1.api.exception.addressException;

import java.util.UUID;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(UUID id) {
        super(errorMessage(id));
    }

    private static String errorMessage(UUID id) {
        return String.format("The following address ID '%s' could not be found", id);
    }
}
