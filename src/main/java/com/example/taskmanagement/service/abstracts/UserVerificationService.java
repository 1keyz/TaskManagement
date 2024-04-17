package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.VerifyUserResponse;

public interface UserVerificationService {
    String createCode(int userId);
    boolean verify(VerifyUserRequest request);

}
