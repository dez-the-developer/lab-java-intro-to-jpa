package com.desmond.ironhack.lab3._introtojpa.repository;

import com.desmond.ironhack.lab3._introtojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}

