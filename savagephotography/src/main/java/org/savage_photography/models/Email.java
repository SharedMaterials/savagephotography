package org.savage_photography.models;

import org.savage_photography.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface Email {

    String getMessage();

    String getEmail();
}
