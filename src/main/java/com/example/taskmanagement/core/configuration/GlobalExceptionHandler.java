package com.example.taskmanagement.core.configuration;

import com.example.taskmanagement.core.utils.exception.problemdetails.BusinessProblemDetails;
import com.example.taskmanagement.core.utils.exception.problemdetails.ValidationProblemDetail;
import com.example.taskmanagement.core.utils.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleRuntimeException(RuntimeException exception){

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails(exception.getMessage());
        return businessProblemDetails;
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
        ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail(errors);
        return validationProblemDetail;

    }
}
