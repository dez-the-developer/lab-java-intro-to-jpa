package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.FlightBooking;
import com.desmond.ironhack.lab3._introtojpa.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    public List<FlightBooking> findAll() {
        return flightBookingRepository.findAll();
    }

    public FlightBooking save(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

    public void delete(Integer id) {
        flightBookingRepository.deleteById(id);
    }

    public FlightBooking findById(Integer id) {
        return flightBookingRepository.findById(id).orElse(null);
    }
}
