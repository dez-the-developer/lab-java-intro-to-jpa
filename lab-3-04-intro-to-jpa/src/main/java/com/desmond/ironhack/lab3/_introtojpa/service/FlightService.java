package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    public void delete(Integer id) {
        flightRepository.deleteById(id);
    }

    public Flight findById(Integer id) {
        return flightRepository.findById(id).orElse(null);
    }
}

