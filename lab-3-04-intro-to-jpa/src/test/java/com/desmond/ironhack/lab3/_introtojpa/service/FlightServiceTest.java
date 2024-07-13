package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

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

    @Test
    public void testFindFlightByNumber() {
        Flight flight = new Flight("FN456", "Airbus A320", 160, 1200);
        flightRepository.save(flight);  // Save flight
        Flight found = flightRepository.findByFlightNumber("FN456");
        assertNotNull(found);
        assertEquals("FN456", found.getFlightNumber());
    }

    @Test
    public void testFindAircraftWithNameContainingBoeing() {
        Flight flight = new Flight("FN789", "Boeing 747", 220, 1300);
        flightRepository.save(flight);  // Save flight
        List<Flight> foundFlights = flightRepository.findByAircraftContaining("Boeing");
        assertFalse(foundFlights.isEmpty());
        assertTrue(foundFlights.stream().anyMatch(flight1 -> flight1.getAircraft().contains("Boeing")));
    }

    @Test
    public void testFindFlightsWithDistanceGreaterThan500() {
        Flight flight = new Flight("FN012", "Boeing 777", 300, 2000);
        flightRepository.save(flight);  // Save flight
        List<Flight> foundFlights = flightRepository.findByFlightMileageGreaterThan(500);
        assertFalse(foundFlights.isEmpty());
        assertTrue(foundFlights.stream().anyMatch(flight1 -> flight1.getFlightMileage() > 500));
    }
}
