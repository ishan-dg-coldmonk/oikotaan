package com.example.backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendRegistrationEmail(String recipientEmail, String regId, String bandName) {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(senderEmail);
            helper.setTo(recipientEmail);
            helper.setSubject("Registration Confirmation");

            String htmlContent = "<html><body>"
                    + "<h3>Dear " + bandName + ",</h3>"
                    + "<p>Thank you for registering!</p>"
                    + "<p>Your Registration ID is: <b>" + regId + "</b></p>"
                    + "<p>Best Regards,</p>"
                    + "<p><i>Team Oikotaan 7</i></p>"
                    + "</body></html>";

            helper.setText(htmlContent, true);

            javaMailSender.send(message);
            logger.info("Registration email sent successfully to {}", recipientEmail);
        } catch (MessagingException e) {
            logger.error("Error sending email to {}: {}", recipientEmail, e.getMessage(), e);
        }
    }
}
