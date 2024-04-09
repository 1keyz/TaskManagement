package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "Kayıt sirasinda Email boş olamaz")
    private String email;
    @NotBlank(message = "Kayıt sirasinda password boş olamaz")
    @Size(min = 6,max = 10,message = "şifre 6 ila 10 karakter arasında olmalıdır")
    private String password;
}
