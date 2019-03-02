package org.savage_photography.models;

import org.savage_photography.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmationEmail implements Email {

    @Autowired
    TemplateRepository repository;

    String email;
    String name;
    String link;

    public ConfirmationEmail(String email, String name, String link) {
        this.email = email;
        this.name = name;
        this.link = link;
    }

    public String getMessage(){
        return String.format(
          repository.getTemplate("confirmation"),
          name,
          link
        );
    }

    public String getEmail(){
        return email;
    }
}
