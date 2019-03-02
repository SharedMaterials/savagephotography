package org.savage_photography.models;

import org.savage_photography.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactEmail implements Email {

    @Autowired
    private TemplateRepository repository;

    private String name;
    private String email;
    private String phoneNumber;
    private String info;

    public ContactEmail(String name, String email, String phoneNumber, String info) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.info = info;
    }

    public String getMessage(){
        return String.format(
                repository.getTemplate("contact"),
                name,
                email,
                phoneNumber,
                info
        );
    }

    public String getEmail(){
        return email;
    }
}