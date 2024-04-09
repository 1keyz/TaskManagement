package com.example.taskmanagement.core.utils.exception.problemdetails;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String type;
}
