package com.example.taskmanagement.service.impl;


import com.example.taskmanagement.model.entity.Mail;
import com.example.taskmanagement.service.abstracts.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
@AllArgsConstructor
public class EmailServiceImple implements EmailService {

    private JavaMailSender sender;
    private TemplateEngine templateEngine;

    public void createTokenMail(Mail mail) throws Exception {
        sendMail(mail);
    }


    public void sendVerifiedMail(Mail mail) throws Exception {
        sendMail(mail);
        mail.setVerify(true);
    }

    @Async
    public void sendMail(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom("hasanyanbal0@gmail.com");
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setSubject(mail.getSubject());


        Context context = new Context();
        context.setVariables(mail.getProperties());
        String processedString = templateEngine.process("email-template.html", context);

        mimeMessageHelper.setText(processedString, true);

        sender.send(mimeMessage);
    }

    private String getHtmlContent(String name , String value) { // content'i buraya uyarlayacam ilerde
        Context context = new Context();
        context.setVariable("content", "tokeniniz üretildi");
        String processedString = templateEngine.process("email-template.html", context);
        return processedString;
    }

}
