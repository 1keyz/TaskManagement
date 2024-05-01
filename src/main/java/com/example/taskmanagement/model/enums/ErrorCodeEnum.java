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
    UNIQUE_FIELD("HY004",HttpStatus.CONFLICT);

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
