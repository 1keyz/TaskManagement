package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import com.example.taskmanagement.service.impl.UserVerificationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-verification")
@AllArgsConstructor
public class UserVerificationController {

    private final UserVerificationService service;

    @PostMapping("/{userId}")
    public String createCode(@PathVariable int userId) {
       return service.createCode(userId);
    }

    @GetMapping
    public boolean verify(@RequestBody VerifyUserRequest request) {
        return service.verify(request);
    }
}
