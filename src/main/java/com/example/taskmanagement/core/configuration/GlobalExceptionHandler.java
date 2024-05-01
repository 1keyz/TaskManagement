package com.example.taskmanagement.core.configuration;

import com.example.taskmanagement.core.utils.exception.problemdetails.*;
import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import com.example.taskmanagement.core.utils.exception.types.CustomAuthenticationException;
import com.example.taskmanagement.core.utils.exception.types.NotFoundException;
import com.example.taskmanagement.core.utils.exception.types.UniqueFieldException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundErrorResponse handleNotFoundException(RuntimeException exception){

        NotFoundErrorResponse notFoundErrorResponse = new NotFoundErrorResponse(exception.getMessage() , HttpStatus.NOT_FOUND);
        return notFoundErrorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemErrorResponse handleValidationException(MethodArgumentNotValidException exception){
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        for (FieldError x : fieldErrors){// Validation kütüphanesini kullanarak aldığımız örnek veriyorum
                                        // b@NotBlank ya da @size gibi eklentilere verdiğimiz hata mesajlarını dönüyor
            errors.add(x.getDefaultMessage());
        }
        ValidationProblemErrorResponse validationProblemErrorResponse = new ValidationProblemErrorResponse(errors,HttpStatus.UNPROCESSABLE_ENTITY);
        return validationProblemErrorResponse;
    }

    @ExceptionHandler(UniqueFieldException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public UniqueFieldErrorResponse handleUniqueFieldException(DataAccessException exception){
        UniqueFieldErrorResponse fieldProblem = new UniqueFieldErrorResponse(HttpStatus.CONFLICT , exception.getMessage());
        return fieldProblem;
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessErrorResponse handleBusinessException(BusinessException exception){
        BusinessErrorResponse detail = new BusinessErrorResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return detail;
    }
}
