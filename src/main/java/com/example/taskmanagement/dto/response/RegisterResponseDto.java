package com.example.taskmanagement.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDto {
    private UserResponseDto userResponseDto;
}
