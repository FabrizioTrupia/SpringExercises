package co.develhope.loginDemo.auth.controllers;

import co.develhope.loginDemo.auth.entities.SignUpActivationDTO;
import co.develhope.loginDemo.auth.entities.SignUpDTO;
import co.develhope.loginDemo.auth.services.SignUpService;
import co.develhope.loginDemo.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpDTO signUpDTO) throws Exception {
       return signUpService.signUp(signUpDTO);
    }

    @PostMapping("/signup/{role}")
    public User signUp(@RequestBody SignUpDTO signUpDTO , @PathVariable String role) throws Exception {
        return signUpService.signUp(signUpDTO , role);
    }

    @PostMapping("/signup/activation")
    public User signUp(@RequestBody SignUpActivationDTO signUpActivationDTO) throws Exception {
       return signUpService.activate(signUpActivationDTO);
    }






}
