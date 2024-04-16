package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.VerifyUserResponse;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.repository.UserVerificationRepository;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
@AllArgsConstructor
public class UserVerificationServiceImpl implements UserVerificationService {
    private UserVerificationRepository repository;
    @Override
    public String createCode(int userId) {
        UserVerification userVerification = new UserVerification();
        userVerification.setUserId(userId);
        userVerification.setCode(randomCode());
        userVerification.setExpirationTime(new Date(System.currentTimeMillis() + 1000 * 60 * 6));
        repository.save(userVerification);
        return userVerification.getCode();
    }

    @Override
    public boolean verify(VerifyUserRequest request) {
        UserVerification userVerification = repository.
                userVerificationIsExist(request.getUserId(),request.getCode()).orElse(null);

        VerifyUserResponse response = new VerifyUserResponse();

        if (userVerification ==null) userVerification.setVerified(false);

        if (!request.getCode().equals(userVerification.getCode())) {
            userVerification.setVerified(false);
        }
        else if (userVerification.getCode().equals(request.getCode())){
            if (new Date(System.currentTimeMillis() + 1000 * 60 ).after(userVerification.getExpirationTime())){
                userVerification.setVerified(false);
                response.setVerify(userVerification.isVerified());
            }
            else {
                userVerification.setVerified(true);
            }
        }
        repository.save(userVerification);
        response.setVerify(userVerification.isVerified());
        return response.isVerify();
    }

    private String randomCode(){
        String rndmStr = "ABCDEFGHIJKLMNOPRSQabcdefghijklmnoprqs123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0 ; i < rndmStr.length();i++){
            code.append(rndmStr.charAt(random.nextInt(48)));
            if (code.length() ==6){
                break;
            }
        }
        return code.toString();
    }
}
