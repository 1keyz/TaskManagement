package com.example.taskmanagement.core.utils.exception.types;


import org.springframework.security.authentication.InsufficientAuthenticationException;

public class CustomAuthenticationException extends InsufficientAuthenticationException {
    public CustomAuthenticationException(String msg) {
        super(msg);
    }
}
