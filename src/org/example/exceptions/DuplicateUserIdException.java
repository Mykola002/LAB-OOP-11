package org.example.exceptions;

public class DuplicateUserIdException extends AccountException {
    public DuplicateUserIdException(String message) {
        super(message);
    }
}