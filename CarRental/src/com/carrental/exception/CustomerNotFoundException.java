package com.carrental.exception;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException() {
        super("Customer not found in the system.");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
