package org.example.exceptions;

public class ExceededLimitException extends AccountException {
    public ExceededLimitException(String message) { super(message); }
}