package com.github.allanccruz.POC1.api.exception.addressException;

import java.util.UUID;

public class OnlyAddressDeleteException extends RuntimeException {

    public OnlyAddressDeleteException(UUID id) {
        super(errorMessage(id));
    }

    private static String errorMessage(UUID id) {
        return String.format
                ("You cannot delete address with ID '%s' because it is the last address remaining for customer", id);
    }
}
