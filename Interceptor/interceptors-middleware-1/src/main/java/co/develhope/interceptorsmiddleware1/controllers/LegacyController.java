package co.develhope.interceptorsmiddleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/legacy")
public class LegacyController {

    @GetMapping
    public String getLegacy(){
        return "This is just old code";
    }


}