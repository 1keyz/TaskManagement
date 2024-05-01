package com.example.taskmanagement.security.serviceimpl;

import com.example.taskmanagement.core.utils.exception.problemdetails.AuthenticationErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

// -> istek -> Rest -> service -> hata fırlatılıyor -> rest exception handler
// -> istek -> security -> rest
// security'de fırlatılan hatayı rest exception handler

@Component("delegatedAuthenticationEntryPoint")
public class DelegatedAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(APPLICATION_JSON_VALUE);// TEXT OLARAK DÖNÜYORDU JSON'A ÇEVİRDİK BURADA


        if (authException instanceof InsufficientAuthenticationException){
            AuthenticationErrorResponse problem = new AuthenticationErrorResponse(HttpStatus.UNAUTHORIZED, "Access Denied");

            OutputStream out = response.getOutputStream();
            com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(out, problem);
            out.flush();
        }
        if( authException instanceof AuthenticationCredentialsNotFoundException) {
            AuthenticationErrorResponse problem = new AuthenticationErrorResponse(HttpStatus.UNAUTHORIZED,"Access Denied");

            OutputStream out = response.getOutputStream();
            com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(out,problem);
            out.flush();
        }

    }

}

