package com.desmond.ironhack.lab3._introtojpa.repository;

import com.desmond.ironhack.lab3._introtojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    // Additional query methods can be added here if needed in the future
}

