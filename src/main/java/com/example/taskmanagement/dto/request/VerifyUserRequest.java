package com.example.taskmanagement.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VerifyUserRequest {
    @NotBlank(message = "Kullanıcı id boş olamaz!")
    private long userId;
    @NotBlank(message = "Kod boş olamaz!")
    private String code;
}
