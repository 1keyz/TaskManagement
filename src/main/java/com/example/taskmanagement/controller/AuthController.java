package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.AuthRequest;
import com.example.taskmanagement.dto.request.LoginRequestDto;
import com.example.taskmanagement.dto.request.RegisterRequestDto;
import com.example.taskmanagement.dto.response.LoginDto;
import com.example.taskmanagement.dto.response.RegisterResponse;
import com.example.taskmanagement.security.helper.JwtHelper;
import com.example.taskmanagement.security.helper.TokenHelper;
import com.example.taskmanagement.service.abstracts.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private AuthService service;
    private TokenHelper tokenHelper;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequestDto requestDto) {
        return ResponseEntity.ok(service.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginRequestDto requestDto) {
        String token = tokenHelper.generateToken(requestDto.getEmail());
        log.info(token);
        return ResponseEntity.ok(service.login(requestDto));
    }

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest request){
        return ResponseEntity.ok(tokenHelper.generateToken(request.getEmail()));
    }
}
