package com.hasbi.billing_service.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
