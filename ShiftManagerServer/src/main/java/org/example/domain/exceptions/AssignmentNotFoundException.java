package org.example.domain.exceptions;

public class ShiftNotAssignedException extends RuntimeException {
    public ShiftNotAssignedException(String message) {
        super(message);
    }
}
