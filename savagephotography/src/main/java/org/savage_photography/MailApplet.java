package org.savage_photography;

import org.savage_photography.service.EmailService;
import org.savage_photography.service.EmailServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MailApplet {
    public static void main(String[] args){
        SpringApplication.run(MailApplet.class, args);
    }

    @Bean
    public EmailService emailService(){
        return new EmailServiceImpl();
    }

}
