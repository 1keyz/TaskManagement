package com.example.taskmanagement.core.utils.exception.types;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
