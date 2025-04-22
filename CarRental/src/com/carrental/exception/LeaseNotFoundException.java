package com.carrental.exception;

public class LeaseNotFoundException extends Exception {

    public LeaseNotFoundException() {
        super("Lease not found in the system.");
    }

    public LeaseNotFoundException(String message) {
        super(message);
    }
}
