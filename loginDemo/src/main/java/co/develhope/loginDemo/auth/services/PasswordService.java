package co.develhope.loginDemo.auth.services;

import co.develhope.loginDemo.auth.entities.RequestPasswordDTO;
import co.develhope.loginDemo.auth.entities.RestorePasswordDTO;
import co.develhope.loginDemo.notification.services.MailNotificationService;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailNotificationService mailNotificationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User requestPassword(RequestPasswordDTO requestPasswordDTO) throws Exception {
      User userFromDb = userRepository.finByEmail(requestPasswordDTO.getEmail());
      if (userFromDb == null || !userFromDb.isActive()) throw new Exception("User is null");
      userFromDb.setPasswordResetCode(UUID.randomUUID().toString());
      mailNotificationService.sendPasswordResetMail(userFromDb);
      return userRepository.save(userFromDb);
    }

    public User restorePassword(RestorePasswordDTO restorePasswordDTO) throws Exception {
        User userFromDb = userRepository.findByPasswordResetCode(restorePasswordDTO.getResetPasswordCode());
        if (userFromDb == null || !userFromDb.isActive()) throw new Exception("User is null");
        userFromDb.setPassword(passwordEncoder.encode(restorePasswordDTO.getNewPassword()));
        userFromDb.setPasswordResetCode(null);


        return userRepository.save(userFromDb);
    }
}
