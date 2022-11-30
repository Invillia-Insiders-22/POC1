package com.github.allanccruz.POC1.api.exception.addressException;

public class AddressMaxLimitException extends RuntimeException {

    public AddressMaxLimitException() {
        super("Maximum number of registered addresses reached");
    }
}
