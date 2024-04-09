package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.dto.response.UserDto;

public interface AuthService {
    RegisterResponse register(RegisterRequestDto requestDto);
    String login(LoginRequestDto requestDto);
}
