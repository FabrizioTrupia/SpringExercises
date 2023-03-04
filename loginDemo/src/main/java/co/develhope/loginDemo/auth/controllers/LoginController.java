package co.develhope.loginDemo.auth.controllers;

import co.develhope.loginDemo.auth.entities.LoginDTO;
import co.develhope.loginDemo.auth.entities.LoginRTO;
import co.develhope.loginDemo.auth.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginRTO login(@RequestBody LoginDTO loginDTO) throws Exception {
        LoginRTO loginRTO = loginService.login(loginDTO);
        if (loginRTO == null) throw new Exception("Cannot login");
        return loginRTO;
    }


}
