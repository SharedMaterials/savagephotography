package org.savage_photography;

import org.savage_photography.service.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class MailApplet {
    public static void main(String[] args){
        SpringApplication.run(MailApplet.class, args);
    }

    @Bean
    public MailService mailService(){
        return new MailService();
    }
}
