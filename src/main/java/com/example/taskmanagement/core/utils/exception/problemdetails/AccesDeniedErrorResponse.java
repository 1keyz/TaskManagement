package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class AccesDeniedErrorResponse extends ErrorResponse{
    public AccesDeniedErrorResponse(HttpStatus status, String detail) {
        setTitle("AccesDeniedException Rule Violation");
        setStatus(HttpStatus.BAD_GATEWAY);
        setErrorEnum(ErrorCodeEnum.ACCES_DENIED_FAILED.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
