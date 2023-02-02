package co.develhope.firstapi4.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/headers")
public class HeaderController {


    @GetMapping
    public String getSwaggerSpecification(HttpServletRequest request){

        String host = request.getHeader(HttpHeaders.HOST);

        return host;
    }




}