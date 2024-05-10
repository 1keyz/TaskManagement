package com.example.taskmanagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCodeEnum {
    GENERAL("HY001",HttpStatus.BAD_REQUEST),
    USER_BLOCKED("HY002",HttpStatus.UNAUTHORIZED),
    NOT_FOUND("HY003", HttpStatus.NOT_FOUND),
    AUTHENTICATION_FAILED("HY004",HttpStatus.UNAUTHORIZED),
    ACCES_DENIED_FAILED("HY005",HttpStatus.FORBIDDEN),
    UNIQUE_FIELD("HY006",HttpStatus.CONFLICT);

    private String errorValue;
    private HttpStatus status;

    ErrorCodeEnum(String errorValue, HttpStatus status) {
        this.errorValue = errorValue;
        this.status = status;
    }
    @JsonValue
    public String getErrorValue() {
        return errorValue;
    }
    @JsonCreator
    public static ErrorCodeEnum fromValue(String value) {
        for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
            if (error.errorValue == value) {
                return error;
            }
        }
        throw new IllegalArgumentException("Invalid error value: " + value);
    }
}
