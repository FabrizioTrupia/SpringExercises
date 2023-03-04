package co.develhope.loginDemo.notification.services;

import co.develhope.loginDemo.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("fabriziotrupia1995@gmail.com");
        sms.setReplyTo("fabriziotrupia1995@gmail.com");
        sms.setSubject("Ti sei iscritto");
        sms.setText("Il codice di attivazione è : " + user.getActivationCode());
        javaMailSender.send(sms);
    }

    public void sendPasswordResetMail(User userFromDb) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(userFromDb.getEmail());
        sms.setFrom("fabriziotrupia1995@gmail.com");
        sms.setReplyTo("fabriziotrupia1995@gmail.com");
        sms.setSubject("Ti sei iscritto");
        sms.setText("Il codice di attivazione è : " + userFromDb.getPasswordResetCode());
        javaMailSender.send(sms);
    }
}
