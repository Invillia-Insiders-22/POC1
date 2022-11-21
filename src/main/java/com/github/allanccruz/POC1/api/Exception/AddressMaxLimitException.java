package com.github.allanccruz.POC1.api.Exception;

public class AddressMaxLimitException extends RuntimeException{
    public AddressMaxLimitException(String errorMessage){
        super(errorMessage);
    }
}
