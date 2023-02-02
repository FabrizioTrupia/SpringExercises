package co.develhope.firstapi3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strings")
public class StringController {

    @GetMapping
    public String getString(@RequestParam String string1 ,@RequestParam(required = false) String string2){
        if(string2 == null){
            return string1;
        } else {
            return string1 + " " + string2;
        }
    }


}