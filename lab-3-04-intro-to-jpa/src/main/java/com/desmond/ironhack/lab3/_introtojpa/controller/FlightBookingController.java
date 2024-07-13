package com.desmond.ironhack.lab3._introtojpa.controller;

import com.desmond.ironhack.lab3._introtojpa.model.FlightBooking;
import com.desmond.ironhack.lab3._introtojpa.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flightbookings")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @GetMapping
    public List<FlightBooking> findAll() {
        return flightBookingService.findAll();
    }

    @PostMapping
    public FlightBooking save(@RequestBody FlightBooking flightBooking) {
        return flightBookingService.save(flightBooking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        flightBookingService.delete(id);
    }

    @GetMapping("/{id}")
    public FlightBooking findById(@PathVariable Integer id) {
        return flightBookingService.findById(id);
    }
}

