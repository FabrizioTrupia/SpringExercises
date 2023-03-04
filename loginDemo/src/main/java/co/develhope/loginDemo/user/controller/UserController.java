package co.develhope.loginDemo.user.controller;

import co.develhope.loginDemo.auth.entities.LoginRTO;
import co.develhope.loginDemo.auth.services.LoginService;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public LoginRTO getProfile(Principal principal){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        LoginRTO rto = new LoginRTO();
        rto.setUser(user);

        return rto;
    }

}
