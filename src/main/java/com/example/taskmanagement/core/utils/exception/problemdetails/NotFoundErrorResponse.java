package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundErrorResponse extends ErrorResponse {
    public NotFoundErrorResponse(String detail , HttpStatus status) {
        setStatus(status);
        setTitle("Business rule Violation");
        setErrorEnum(ErrorCodeEnum.NOT_FOUND.getErrorValue());
        setCode(status.value());
        setDetail(detail);
    }
}
