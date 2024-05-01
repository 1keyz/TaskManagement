package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class UniqueFieldErrorResponse extends ErrorResponse {
    public UniqueFieldErrorResponse(HttpStatus status , String detail) {
        setStatus(status);
        setTitle("Unique Field Rule Violation");
        setErrorEnum(ErrorCodeEnum.UNIQUE_FIELD.getErrorValue());
        setDetail(detail);
        setCode(status.value());
    }
}
