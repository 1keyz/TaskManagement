package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

public class AuthenticationProblem extends ProblemDetails{
    public AuthenticationProblem(HttpStatus status , String details) {
        setStatus(status);
        setTitle("Authentication Rule Violation");
        setErrorEnum(ErrorEnum.USER_BLOCKED.getErrorValue());
        setCode(status.value());
        setDetail(details);
    }
}
