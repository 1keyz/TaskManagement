package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class AuthenticationErrorResponse extends ErrorResponse {
    public AuthenticationErrorResponse(HttpStatus status , String details) {
        setStatus(status);
        setTitle("Authentication Rule Violation");
        setErrorEnum(ErrorCodeEnum.USER_BLOCKED.getErrorValue());
        setCode(status.value());
        setDetail(details);
    }
}
