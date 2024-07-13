package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.FlightBooking;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightBookingRepository;
import com.desmond.ironhack.lab3._introtojpa.repository.CustomerRepository;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightRepository;
import com.desmond.ironhack.lab3._introtojpa.model.Customer;
import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import com.desmond.ironhack.lab3._introtojpa.model.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FlightBookingServiceTest {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    private FlightBooking flightBooking;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer("Jane Doe", CustomerStatus.GOLD, 2000);
        customer = customerRepository.save(customer);  // Save customer first
        Flight flight = new Flight("DL123", "Airbus A320", 200, 1500);
        flight = flightRepository.save(flight);  // Save flight first
        flightBooking = new FlightBooking(customer, flight);
        flightBookingRepository.save(flightBooking);
    }

    @Test
    public void testCreateFlightBooking() {
        FlightBooking found = flightBookingRepository.findById(flightBooking.getBookingId()).orElse(null);
        assertNotNull(found);
        assertEquals(flightBooking.getBookingId(), found.getBookingId());
    }

    @Test
    public void testFindAll() {
        assertFalse(flightBookingRepository.findAll().isEmpty());
    }

    @Test
    public void testDeleteFlightBooking() {
        flightBookingRepository.deleteById(flightBooking.getBookingId());
        assertFalse(flightBookingRepository.findById(flightBooking.getBookingId()).isPresent());
    }
}


