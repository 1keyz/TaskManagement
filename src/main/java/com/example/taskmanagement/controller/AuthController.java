package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AuthRequest;
import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.security.helper.JwtHelper;
import com.example.taskmanagement.security.helper.TokenHelper;
import com.example.taskmanagement.service.abstracts.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService service;
    private TokenHelper tokenHelper;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequestDto requestDto) {
        return service.register(requestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto) {
        String token = tokenHelper.generateToken(requestDto.getEmail());
        return ResponseEntity.ok(service.login(requestDto));
    }

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest request){
        return ResponseEntity.ok(tokenHelper.generateToken(request.getEmail()));
    }
}
