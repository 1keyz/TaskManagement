package com.example.taskmanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String email;
    private String message;
}
