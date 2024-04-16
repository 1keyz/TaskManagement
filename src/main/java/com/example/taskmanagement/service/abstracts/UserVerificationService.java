package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.VerifyUserRequest;

public interface UserVerificationService {
    String createCode(int userId);
    boolean verify(VerifyUserRequest request);

}
