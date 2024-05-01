package com.example.taskmanagement.core.utils.exception.types;


public class CustomAuthenticationException extends org.springframework.security.core.AuthenticationException{
    public CustomAuthenticationException(String msg) {
        super(msg);
    }
}
