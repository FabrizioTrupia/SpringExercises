package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;


@RequestMapping("/flights")
public class FlightController {

    String generateRandomString(){
        int leftLimit = 0;
        int rightLimit = 50;
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public FlightStatus getRandomStatus(){
        return FlightStatus.values()[new Random().nextInt(FlightStatus.values().length)];
    }

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("")
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

}