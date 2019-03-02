package org.savage_photography.service;

import org.savage_photography.models.Email;
import org.springframework.context.annotation.Bean;


public class MailService {

    private final String CONFIRMED_URL = "localhost:8080/contact";

    public void sendEmail(Email email){
        System.out.println(email.getEmail());
        System.out.println(email.getMessage());
    }

    public String getConfirmationLink(
            String name,
            String email,
            String phoneNumber,
            String info
    ){
        StringBuilder link = new StringBuilder();
        link.append(CONFIRMED_URL);
        link.append("/" + name);
        link.append("/" + email);
        link.append("/" + phoneNumber);
        link.append("/" + info);
        return link.toString();
    }
}
