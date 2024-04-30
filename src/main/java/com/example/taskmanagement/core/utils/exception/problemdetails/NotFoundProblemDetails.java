package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundProblemDetails extends ProblemDetails{
    public NotFoundProblemDetails(String detail , HttpStatus status) {
        setStatus(status);
        setTitle("Business rule Violation");
        setErrorEnum(ErrorEnum.NOT_FOUND.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
