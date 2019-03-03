package org.savage_photography;


import org.savage_photography.models.ContactEmail;
import org.savage_photography.service.EmailService;
import org.savage_photography.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    @Autowired
    public EmailService emailService;

    @PostMapping("/contact/{name}/{email}/{phone}")
    public void doService(
            @PathVariable("name") String name,
            @PathVariable("email") String email,
            @PathVariable("phone") String phoneNumber,
            @RequestParam(name = "info", defaultValue = "N/A") String info
    ){
        if(name != null && !(name.isEmpty())
        && email != null && !(name.isEmpty())
        && phoneNumber != null && !(phoneNumber.isEmpty())
        && info != null && !(info.isEmpty()))
            emailService.sendContact(
                    name,
                    email,
                    phoneNumber,
                    info
            );
    }
}
