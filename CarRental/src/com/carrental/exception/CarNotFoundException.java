package com.carrental.exception;

public class CarNotFoundException extends Exception {

    public CarNotFoundException() {
        super("Car not found in the system.");
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
