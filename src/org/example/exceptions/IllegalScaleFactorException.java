package org.example.exceptions;

public class IllegalScaleFactorException extends RuntimeException {
    public IllegalScaleFactorException(String message) {
        super(message);
    }
}