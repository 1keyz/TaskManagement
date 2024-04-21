package com.example.taskmanagement.service.abstracts;

import com.example.taskmanagement.dto.response.MailResponse;
import com.example.taskmanagement.dto.response.UserDto;
import com.example.taskmanagement.model.entity.Mail;
import com.example.taskmanagement.model.entity.User;


import java.io.IOException;

public interface EmailService {
    void createTokenMail(Mail mail) throws Exception;
    void verifyTokenMail(Mail mail) throws Exception;
}
