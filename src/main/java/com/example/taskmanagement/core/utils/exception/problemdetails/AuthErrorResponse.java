package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class AuthErrorResponse extends ErrorResponse{
    public AuthErrorResponse(HttpStatus status ,String detail) {
        setTitle("AuthenticationException Rule Violation");
        setStatus(status);
        setErrorEnum(ErrorCodeEnum.AUTHENTICATION_FAILED.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
