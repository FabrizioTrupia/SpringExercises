package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cars")
@RestController
public class CarController {

    @GetMapping
    public String getCar (CarDTO car) {
        return car.toString();
    }

    @PostMapping
    public String postCar(@RequestBody CarDTO car){
        return car.toString();
    }

}