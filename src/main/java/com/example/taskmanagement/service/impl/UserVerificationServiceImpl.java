package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.request.VerifyUserRequest;
import com.example.taskmanagement.model.entity.Mail;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.model.entity.UserVerification;
import com.example.taskmanagement.model.enums.UserStatus;
import com.example.taskmanagement.repository.UserVerificationRepository;
import com.example.taskmanagement.service.abstracts.EmailService;
import com.example.taskmanagement.service.abstracts.UserService;
import com.example.taskmanagement.service.abstracts.UserVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserVerificationServiceImpl implements UserVerificationService {
    private UserVerificationRepository repository;
    private UserService userService;
    private EmailService emailService;
    @Override
    public UserVerification createCode( User user) {
        UserVerification userVerification = new UserVerification();
        userVerification.setUserl(user);
        userVerification.setCode(randomCode());
        userVerification.setExpirationTime(LocalDateTime.now().plus(6, ChronoUnit.MINUTES));
        repository.save(userVerification);


        Mail mail = Mail.builder()
                .to(user.getEmail())
                .subject("create a new token")
                .properties(getProperties(userVerification))
                .build();
        try {
            emailService.sendUserVerificationMail(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userVerification;
    }

    @Override
    public boolean verify(VerifyUserRequest request) {
        UserVerification lastUserVerification = repository.getUserVerificationLastUserByUserId(request.getUserId());

        if (lastUserVerification == null) return false;

        if (!lastUserVerification.getCode().equals(request.getCode())) return false;

        if (LocalDateTime.now().isAfter(lastUserVerification.getExpirationTime())) return false;

        lastUserVerification.setVerified(true);
        lastUserVerification.setUpdatedAt(LocalDateTime.now());
        lastUserVerification.getUserl().setUserStatus(UserStatus.ACTIVE);

        User user = userService.getById(request.getUserId());

        Mail mail = Mail.builder()
                .to(user.getEmail())
                .subject("the token is verify")
                .properties(getProperties(lastUserVerification))
                .build();
        try {
            emailService.sendVerifiedMail(mail);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        repository.save(lastUserVerification);
        return true;
    }

    public Map<String,Object> getProperties(UserVerification userVerification){
        Map<String, Object> properties = new HashMap<>();
        properties.put("codes", userVerification.getCode());
        properties.put("tokenCreateDate", userVerification.getCreatedAt());
        properties.put("tokenExpirationTime", userVerification.getExpirationTime());
        properties.put("tokenVerify", userVerification.isVerified());
        return properties;
    }


    private String randomCode(){
        String rndmStr = "ABCDEFGHIJKLMNOPRSQabcdefghijklmnoprqs123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0 ; i < rndmStr.length();i++){
            code.append(rndmStr.charAt(random.nextInt(47)));
            if (code.length() ==6){
                break;
            }
        }
        return code.toString();
    }
}
