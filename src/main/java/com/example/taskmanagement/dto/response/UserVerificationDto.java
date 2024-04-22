package com.example.taskmanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserVerificationDto {
    private String code;
    private LocalDateTime expirationTime;
    private boolean verified;
}
