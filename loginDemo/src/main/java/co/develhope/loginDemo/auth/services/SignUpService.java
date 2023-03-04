package co.develhope.loginDemo.auth.services;

import co.develhope.loginDemo.auth.entities.SignUpActivationDTO;
import co.develhope.loginDemo.auth.entities.SignUpDTO;
import co.develhope.loginDemo.notification.services.MailNotificationService;
import co.develhope.loginDemo.user.entities.Role;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.RoleRepository;
import co.develhope.loginDemo.user.repositories.UserRepository;
import co.develhope.loginDemo.user.utilies.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailNotificationService mailNotificationService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public User signUp(SignUpDTO signUpDTO) throws Exception {
       return this.signUp(signUpDTO , Roles.REGISTERED);
    }

    public User signUp(SignUpDTO signUpDTO , String role) throws Exception {
        User user = new User();
        user.setName(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());
        user.setSurname(signUpDTO.getSurname());
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString()); //genera un codice univoco a 36 caratteri
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword())); //permette di non rendere la pass in chiaro

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName(role.toUpperCase());
        if (!userRole.isPresent()) throw new Exception("Cannot set user role");
        roles.add(userRole.get());
        user.setRoles(roles);

        mailNotificationService.sendActivationEmail(user);
        return userRepository.save(user);
    }


    public User activate(SignUpActivationDTO signUpActivationDTO) throws Exception {
        User user = userRepository.getByActivationCode(signUpActivationDTO.getActivationCode());
        if (user == null) throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);
    }
}
