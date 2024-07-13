package com.desmond.ironhack.lab3._introtojpa.repository;

import com.desmond.ironhack.lab3._introtojpa.model.Customer;
import com.desmond.ironhack.lab3._introtojpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
