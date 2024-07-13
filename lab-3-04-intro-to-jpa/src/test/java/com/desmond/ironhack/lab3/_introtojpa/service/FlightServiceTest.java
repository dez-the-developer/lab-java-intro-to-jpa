package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FlightServiceTest {

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        flight = new Flight("DL123", "Airbus A320", 200, 1500);
        flightRepository.save(flight);
    }

    @Test
    public void testCreateFlight() {
        Flight found = flightRepository.findById(flight.getFlightId()).orElse(null);
        assertNotNull(found);
        assertEquals(flight.getFlightId(), found.getFlightId());
    }

    @Test
    public void testFindAll() {
        assertFalse(flightRepository.findAll().isEmpty());
    }

    @Test
    public void testDeleteFlight() {
        flightRepository.deleteById(flight.getFlightId());
        assertFalse(flightRepository.findById(flight.getFlightId()).isPresent());
    }
}
