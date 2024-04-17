package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.VerifyUserResponse;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import com.example.taskmanagement.service.impl.UserVerificationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-verification")
@AllArgsConstructor
public class UserVerificationController {

    private final UserVerificationService service;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createCode(@PathVariable int userId) {
       return ResponseEntity.ok(service.createCode(userId));
    }

    @GetMapping
    public ResponseEntity<VerifyUserResponse> verify(@RequestBody VerifyUserRequest request) {
        VerifyUserResponse verifyUserResponse = new VerifyUserResponse();
        verifyUserResponse.setVerify(service.verify(request));
        return ResponseEntity.ok(verifyUserResponse);
    }
}
