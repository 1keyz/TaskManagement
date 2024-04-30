package com.example.taskmanagement.core.utils.exception.problemdetails;

import com.example.taskmanagement.model.enums.ErrorEnum;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    private HttpStatus status;
    private String errorEnum;
    private String title;
    private String detail;
    private int code;


}
