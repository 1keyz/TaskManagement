package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.service.abstracts.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService service;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequestDto requestDto) {
        return service.register(requestDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto requestDto) {
        return service.login(requestDto);
    }
}
