package lt.ivl.webExternalApp.service;

import lt.ivl.webExternalApp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment environment;

    public void sendCustomerVerificationEmail(Customer customer, String token) {
        final SimpleMailMessage email = constructCustomerVerificationEmail(customer, token);
        mailSender.send(email);
    }

    private SimpleMailMessage constructCustomerVerificationEmail(Customer customer, String token) {
        final String recipientAddress = customer.getEmail();
        final String subject = "Registracijos patvirtinimas";
        final String appUrl = environment.getProperty("app.url");
        // TODO: get token
        final String confirmationUrl = appUrl + "activation?token=" + token;
        final String message1 = String.format("Sveiki, %s %s,", customer.getFirstName(), customer.getLastName());
        final String message2 = "Jūs sėkmingai užsiregistravote. Prašome patvirtinti savo registraciją.";

        final SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(environment.getProperty("support.email"));
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message1 + " \r\n" + message2 + " \r\n" + confirmationUrl);
        return email;
    }
}
