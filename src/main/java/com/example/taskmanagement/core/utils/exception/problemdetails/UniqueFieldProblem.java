package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

public class UniqueFieldProblem extends ProblemDetails{
    public UniqueFieldProblem(HttpStatus status , String detail) {
        setStatus(status);
        setTitle("Unique Field Rule Violation");
        setErrorEnum(ErrorEnum.UNIQUE_FIELD.getErrorValue());
        setDetail(detail);
        setCode(status.value());
    }
}
