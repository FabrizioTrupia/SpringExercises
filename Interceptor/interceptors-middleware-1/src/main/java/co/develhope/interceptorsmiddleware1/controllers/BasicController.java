package co.develhope.interceptorsmiddleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@RequestMapping("/time")
public class BasicController {

    @GetMapping
    public LocalDateTime getDateAndTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }

}