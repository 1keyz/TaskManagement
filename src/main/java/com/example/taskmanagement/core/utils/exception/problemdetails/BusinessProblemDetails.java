package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(String detail) {
        setTitle("Business rule Violation");
        setType("Business Exception");
        setDetail(detail);
    }
}
