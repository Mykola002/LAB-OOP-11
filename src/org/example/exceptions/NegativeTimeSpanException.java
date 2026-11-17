package org.example.exceptions;

public class NegativeTimeSpanException extends RuntimeException {
    public NegativeTimeSpanException(String message) {
        super(message);
    }
}