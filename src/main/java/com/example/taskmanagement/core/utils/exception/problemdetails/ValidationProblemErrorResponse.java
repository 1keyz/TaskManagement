package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ValidationProblemErrorResponse extends ErrorResponse {
    private List<String> errors;

    public ValidationProblemErrorResponse(List<String> errors , HttpStatus status) {
        setStatus(status);
        setTitle("Validation rule Violation");
        setCode(status.value());
        setDetail("one or more validation error(s)!");
        this.errors = errors;
    }
}
