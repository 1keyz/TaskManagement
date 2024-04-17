package com.example.taskmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VerifyUserRequest {
    private int userId;
    private String code;
}
