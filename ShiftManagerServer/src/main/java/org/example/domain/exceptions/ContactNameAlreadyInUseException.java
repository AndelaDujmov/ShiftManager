package org.example.domain.exceptions;

public class ContactNameAlreadyInUseException extends RuntimeException {
    public ContactNameAlreadyInUseException(String message) {
        super(message);
    }
}
