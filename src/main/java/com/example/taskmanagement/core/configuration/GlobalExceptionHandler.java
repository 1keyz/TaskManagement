package com.example.taskmanagement.core.configuration;

import com.example.taskmanagement.core.utils.exception.problemdetails.*;
import com.example.taskmanagement.core.utils.exception.types.CustomAuthenticationException;
import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.core.utils.exception.types.NotFoundException;
import com.example.taskmanagement.core.utils.exception.types.UniqueFieldException;
import io.jsonwebtoken.JwtException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundProblemDetails handleRuntimeException(RuntimeException exception){

        NotFoundProblemDetails notFoundProblemDetails = new NotFoundProblemDetails(exception.getMessage() , HttpStatus.NOT_FOUND);
        return notFoundProblemDetails;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetail handleValidationException(MethodArgumentNotValidException exception){
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        for (FieldError x : fieldErrors){// Validation kütüphanesini kullanarak aldığımız örnek veriyorum
                                        // b@NotBlank ya da @size gibi eklentilere verdiğimiz hata mesajlarını dönüyor
            errors.add(x.getDefaultMessage());
        }
        ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail(errors,HttpStatus.UNPROCESSABLE_ENTITY);
        return validationProblemDetail;
    }

    @ExceptionHandler(UniqueFieldException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public UniqueFieldProblem handleUniqueFieldException(DataAccessException exception){
        UniqueFieldProblem fieldProblem = new UniqueFieldProblem(HttpStatus.CONFLICT , exception.getMessage());
        return fieldProblem;
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetail handleBusinessException(BusinessException exception){
        BusinessProblemDetail detail = new BusinessProblemDetail(HttpStatus.BAD_REQUEST,exception.getMessage());
        return detail;
    }

}
