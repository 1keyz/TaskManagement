package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.LoginResponseDto;
import com.example.taskmanagement.dto.response.RegisterResponseDto;
import com.example.taskmanagement.model.entity.User;

public interface AuthService {
    RegisterResponseDto register(RegisterRequestDto requestDto);
    LoginResponseDto login(LoginRequestDto requestDto);

    User getCurrentUser();
}
