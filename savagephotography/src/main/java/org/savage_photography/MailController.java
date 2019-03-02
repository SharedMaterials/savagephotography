package org.savage_photography;


import org.savage_photography.models.ConfirmationEmail;
import org.savage_photography.models.ContactEmail;
import org.savage_photography.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value="/confirm/{name}/{email}/{phone}/{info}", method = RequestMethod.POST)
    public String confirmEmail(
            @PathVariable("name") String name,
            @PathVariable("email") String email,
            @PathVariable("phone") String phoneNumber,
            @PathVariable("info") String info
    ){
        if(name != null && !(name.isEmpty())
        && email != null && !(name.isEmpty())
        && phoneNumber != null && !(phoneNumber.isEmpty())
        && info != null && !(info.isEmpty())){
            String confirmationLink = mailService.getConfirmationLink(
                name, email, phoneNumber, info
            );
            mailService.sendEmail(new ConfirmationEmail(
                    email,
                    name,
                    confirmationLink
                )
            );
        }
        return "{\"success\": true}";
    }

    @RequestMapping(value="/contact/{name}/{email}/{phone}/{info}", method = RequestMethod.GET)
    public void doService(
            @PathVariable("name") String name,
            @PathVariable("email") String email,
            @PathVariable("phone") String phoneNumber,
            @PathVariable("info") String info
    ){
        if(name != null && !(name.isEmpty())
                && email != null && !(name.isEmpty())
                && phoneNumber != null && !(phoneNumber.isEmpty())
                && info != null && !(info.isEmpty()))
            mailService.sendEmail(new ContactEmail(
                    name,
                    email,
                    phoneNumber,
                    info
            ));

        //TODO learn to load an html from the web app resource
    }
}
