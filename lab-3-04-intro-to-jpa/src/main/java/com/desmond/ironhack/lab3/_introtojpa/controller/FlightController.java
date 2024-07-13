package com.desmond.ironhack.lab3._introtojpa.controller;

import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import com.desmond.ironhack.lab3._introtojpa.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @PostMapping
    public Flight save(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        flightService.delete(id);
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable Integer id) {
        return flightService.findById(id);
    }
}

