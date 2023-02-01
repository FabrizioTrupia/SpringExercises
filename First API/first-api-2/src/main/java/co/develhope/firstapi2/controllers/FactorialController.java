package co.develhope.firstapi2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping(value ="/factorial/{n}")
    public String getFactorial(@PathVariable String n){
        return "N " + n;
    }

}