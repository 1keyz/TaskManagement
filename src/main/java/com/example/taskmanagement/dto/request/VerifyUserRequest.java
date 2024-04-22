package com.example.taskmanagement.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VerifyUserRequest {
    @NotBlank(message = "User id boş olamaz!")
    private long userId;
    @NotBlank(message = "code boş olamaz!")
    private String code;
}
