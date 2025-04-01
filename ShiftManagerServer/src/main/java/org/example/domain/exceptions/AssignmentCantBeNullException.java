package org.example.domain.exceptions;

public class AssignmentCantBeNullException extends RuntimeException {
    public AssignmentCantBeNullException(String message) {
        super(message);
    }
}
