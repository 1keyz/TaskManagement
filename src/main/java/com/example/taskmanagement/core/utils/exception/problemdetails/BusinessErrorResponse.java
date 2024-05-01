package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class BusinessErrorResponse extends ErrorResponse {
    public BusinessErrorResponse(HttpStatus status , String detail) {
        setStatus(status);
        setTitle("Business Rule Violation");
        setErrorEnum(ErrorCodeEnum.GENERAL.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
