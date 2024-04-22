package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.model.entity.Mail;

public interface EmailService {
    void createTokenMail(Mail mail) throws Exception;
    void sendVerifiedMail(Mail mail) throws Exception;
}
