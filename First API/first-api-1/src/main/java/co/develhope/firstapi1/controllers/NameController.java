package co.develhope.firstapi1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping
    public String getName(){
        return "Fabrizio";
    }

    @PostMapping
    public StringBuilder postName(){
        return new StringBuilder("oizirbaF");
    }

}