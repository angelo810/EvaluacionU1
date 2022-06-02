package com.patients.patients.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(final String message) {
        super(message);
    }
    
}