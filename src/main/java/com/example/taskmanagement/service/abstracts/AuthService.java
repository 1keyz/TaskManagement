package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.LoginDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.User;

public interface AuthService {
    RegisterResponse register(RegisterRequestDto requestDto);
    LoginDto login(LoginRequestDto requestDto);

    User getCurrentUser();
}
