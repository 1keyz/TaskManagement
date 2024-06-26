package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "Email boş olamaz!")
    @Email(message = "Email formata uymuyor : user@host.com")
    private String email;
    @NotBlank(message = "Şifre boş olamaz!")
    private String password;
}
