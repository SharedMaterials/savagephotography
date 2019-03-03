package org.savage_photography.models;

import org.springframework.mail.SimpleMailMessage;

public class ContactEmail extends SimpleMailMessage {

    public ContactEmail(String to, String subject, String message) {
        this.setTo(to);
        this.setSubject(subject);
        this.setText(message);    }
}