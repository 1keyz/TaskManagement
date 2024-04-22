package com.example.taskmanagement.dto.request;

import com.example.taskmanagement.model.enums.UserStatus;
import jakarta.validation.constraints.Email;
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
public class RegisterRequestDto {
    @NotBlank(message = "firstname boş olamaz!")
    private String firstName;
    @NotBlank(message = "lastname boş olamaz!")
    private String lastName;
    @NotBlank(message = "email boş olamaz!")
    @Email(message = "örnek : user@host.com")
    private String email;
    @NotBlank(message = "password boş olamaz!")
    @Size(min = 6,max = 10 , message = "şifre uzunluğu 6 ile 10 karakter arasında olmalıdır!")
    private String password;
    private String phoneNumber;
}
