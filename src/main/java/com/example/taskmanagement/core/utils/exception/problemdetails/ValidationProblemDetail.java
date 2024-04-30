package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ValidationProblemDetail extends ProblemDetails{
    private List<String> errors;

    public ValidationProblemDetail(List<String> errors , HttpStatus status) {
        setStatus(status);
        setTitle("Validation rule Violation");
        setCode(status.value());
        setDetail("one or more validation error(s)!");
        this.errors = errors;
    }
}
