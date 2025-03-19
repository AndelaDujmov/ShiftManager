package org.example.domain.exceptions;

public class ShiftCantBeNullException extends RuntimeException {
    public ShiftCantBeNullException(String message) {
        super(message);
    }
}
