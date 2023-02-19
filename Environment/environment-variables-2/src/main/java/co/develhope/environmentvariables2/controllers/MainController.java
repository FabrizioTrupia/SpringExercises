package co.develhope.environmentvariables2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private Environment environment;


    @GetMapping("/name")
    public String name(){
        return "Fabrizio";
    }

    @GetMapping("/test")
    public String test(){
        return environment.getProperty("myCustomEnvs.welcomeMsg");
    }

    @GetMapping("/prod")
    public String prod(){
        return environment.getProperty("myCustomEnvs.welcomeMsg");
    }
}