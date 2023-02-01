package co.develhope.firstapi4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HeaderController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public ModelAndView getDomain(@PathVariable("input") String input) {

        ModelAndView modelandView = new ModelAndView("result");

        modelandView.addObject("headers", getHeadersInfo());

        return modelandView;

    }


    //get request headers
    private Map<String, String> getHeadersInfo() {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

}