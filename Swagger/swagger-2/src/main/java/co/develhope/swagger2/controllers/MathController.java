package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/math")
@RestController
public class MathController {

    @GetMapping
    public String welcomeMathMsg(){
        return "Welcome";
    }

    @GetMapping ("/division")
    public ArithmeticOperation getDivisionInfo(){
        String [] array = {"Anti-commutativity', 'Non-associativity', 'Predecessor"};
        return new ArithmeticOperation("Division" , 2 , "addend + addend = sum", array);
    }

    @GetMapping("/multiplication")
    public int getMultiplication (@RequestParam int a , @RequestParam int b){
        return a * b;
    }

}