package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.UserVerificationDto;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-verification")
@AllArgsConstructor
public class UserVerificationController {

    private final UserVerificationService userVerificationService;


    @GetMapping
    public ResponseEntity<UserVerificationDto> verify(@RequestBody VerifyUserRequest request) {
        UserVerificationDto userVerificationDto = new UserVerificationDto();
        userVerificationDto.setVerified(userVerificationService.verify(request));
        return ResponseEntity.ok(userVerificationDto);
    }
}
