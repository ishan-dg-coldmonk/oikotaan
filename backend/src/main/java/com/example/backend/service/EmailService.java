package com.example.backend.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            helper.setSubject("Oikotaan 7 | Registration Confirmation | " + regId);

            String htmlContent = "<html>"
                    + "<body style='font-family: Arial, sans-serif; margin: 0; padding: 0;'>"
                    + "<div style='padding: 20px;'>"
                    + "<div style='text-align: center; padding: 10px;'>"
                    + "<img src='cid:eventLogo' alt='Event Logo' style='width: 180px; height: 160px; margin: 0px;' />"
                    + "</div>"
                    + "<div style='background-color: #ffffff; padding: 20px; border-radius: 8px;'>"
                    + "<h2 style='text-align: center; color: #4CAF50;'>Greetings from Team Euphony Oikotaan!</h2>"
                    + "<p>Hi <b>" + bandName + "</b>,</p>"
                    + "<p>We are thrilled to inform you that your registration for <b>Oikotaan 7</b> has been successfully processed.</p>"
                    + "<p><b>Registration Number:</b> " + regId + "</p>"
                    + "<p>Please keep this number handy for any future communication with us.</p>"
                    + "<h3>Next Steps:</h3>"
                    + "<ul>"
                    + "<li>Your submitted composition will be reviewed by the <b>Euphony Oikotaan Selection Team</b>.</li>"
                    + "<li>Selected participants will be contacted via phone by <b>DD/MM 2025</b>.</li>"
                    + "<li>Confirmed performers will receive a detailed confirmation letter by <b>DD/MM 2025</b>.</li>"
                    + "</ul>"
                    + "<p>We look forward to seeing you rock the stage and create magic!</p>"
                    + "<p>For queries, feel free to contact us at <b>91430XXXXX</b>.</p>"
                    + "</div>"
                    + "<div style='text-align: center; padding: 10px; color: #777;'>"
                    + "<i>Welcome to the Oikotaan Family!</i>"
                    + "</div>"
                    + "<div style='text-align: left; padding: 10px;'>"
                    + "<img src='cid:euphonyLogo' alt='Euphony Logo' style='width: 120px; height: 140px; margin: 5px;' />"
                    + "<img src='cid:iiestLogo' alt='IIEST Logo' style='width: 120px; height: 140px; margin: 5px;' />"
                    + "</div>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlContent, true);

            // Add inline resources
            Resource euphonyLogo = new ClassPathResource("static/euphony-logo-white.png");
            helper.addInline("euphonyLogo", euphonyLogo.getFile());
            Resource iiestLogo = new ClassPathResource("static/iiest-white.png");
            helper.addInline("iiestLogo", iiestLogo.getFile());
            Resource eventLogo = new ClassPathResource("static/fest-logo.jpg");
            helper.addInline("eventLogo", eventLogo.getFile());

            javaMailSender.send(message);
            logger.info("Registration email sent successfully to {}", recipientEmail);
        } catch (Exception e) {
            logger.error("Failed to send registration email", e);
        }
    }
}
