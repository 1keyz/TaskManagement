package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

public class BusinessProblemDetail extends ProblemDetails{
    public BusinessProblemDetail(HttpStatus status , String detail) {
        setStatus(status);
        setTitle("Business Rule Violation");
        setErrorEnum(ErrorEnum.GENERAL.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
