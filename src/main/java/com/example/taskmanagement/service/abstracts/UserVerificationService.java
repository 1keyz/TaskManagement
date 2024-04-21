package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.entity.UserVerification;

public interface UserVerificationService {
    UserVerification createCode(User user);
    boolean verify(VerifyUserRequest request);
    String createCodeForLogin();

}
