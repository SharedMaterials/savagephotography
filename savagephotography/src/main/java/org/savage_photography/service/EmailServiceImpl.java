package org.savage_photography.service;

import org.savage_photography.models.ContactEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private final String TEMPLATE = "Name: %s \n Email: %s \n Phone Number: %s \n Info(Optional): %s";

    @Autowired
    public JavaMailSender emailSender;

    public void sendContact(String name, String email, String phone, String info){
        SimpleMailMessage message = new ContactEmail(
            "carissa.savage@me.com",
            "[New Contact]",
            getMessageText(
                name, email, phone, info
            )
        );
        emailSender.send(message);
    }

    private String getMessageText(String name, String email, String phone, String info) {
        return String.format(
            TEMPLATE,
            name, email, phone, info
        );
    }
}