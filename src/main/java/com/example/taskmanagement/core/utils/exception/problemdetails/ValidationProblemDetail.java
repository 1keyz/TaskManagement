package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationProblemDetail extends ProblemDetails{
    private List<String> errors;

    public ValidationProblemDetail(List<String> errors) {
        setTitle("Validation rule Violation");
        setType("ValidationException");
        setDetail("one or more validation error(s)!");
        this.errors = errors;
    }
}
