package org.example.exceptions;

public class IllegalInputTimeSpanException extends RuntimeException {
    public IllegalInputTimeSpanException(String message) {
        super(message);
    }
}