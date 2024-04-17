package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.VerifyUserResponse;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.repository.UserVerificationRepository;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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
                getUserVerificationByCodeAndUserId(request.getUserId(),request.getCode()).orElse(null);

        if (userVerification == null) return false;

        else {
            String lastCode = repository.getUserVerificationLastCodeByUserId(request.getUserId());

            if (!lastCode.equals(request.getCode())) return false;
            else if (lastCode.equals(request.getCode()) &&
                    new Date(System.currentTimeMillis() + 1000 * 60 ).after(userVerification.getExpirationTime())) {
                userVerification.setVerified(true);
                repository.save(userVerification);
                return true;
            }
        }

        return true;
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
