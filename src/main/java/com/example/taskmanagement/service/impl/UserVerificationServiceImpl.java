package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.dto.response.VerifyUserResponse;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.repository.UserVerificationRepository;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        userVerification.setExpirationTime(LocalDateTime.now().plus(6, ChronoUnit.MINUTES));
        repository.save(userVerification);
        return userVerification.getCode();
    }

    @Override
    public boolean verify(VerifyUserRequest request) {
        UserVerification lastUserVerification = repository.getUserVerificationLastUserByUserId(request.getUserId());

        if (lastUserVerification == null) return false;

        if (!lastUserVerification.getCode().equals(request.getCode())) return false;

        if (LocalDateTime.now().isBefore(lastUserVerification.getExpirationTime())) return false;

        lastUserVerification.setVerified(true);
        lastUserVerification.setUpdatedAt(LocalDateTime.now());
        repository.save(lastUserVerification);
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
