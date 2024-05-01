package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String errorEnum;
    private String title;
    private String detail;
    private int code;
}
