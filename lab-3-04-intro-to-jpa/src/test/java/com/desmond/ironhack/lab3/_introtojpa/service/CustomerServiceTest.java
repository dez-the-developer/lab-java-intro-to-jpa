package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.Customer;
import com.desmond.ironhack.lab3._introtojpa.model.CustomerStatus;
import com.desmond.ironhack.lab3._introtojpa.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", CustomerStatus.SILVER, 1000);
        customerRepository.save(customer);
    }

    @Test
    public void testCreateCustomer() {
        Customer found = customerRepository.findById(customer.getCustomerId()).orElse(null);
        assertNotNull(found);
        assertEquals(customer.getCustomerId(), found.getCustomerId());
    }

    @Test
    public void testFindAll() {
        assertFalse(customerRepository.findAll().isEmpty());
    }

    @Test
    public void testDeleteCustomer() {
        customerRepository.deleteById(customer.getCustomerId());
        assertFalse(customerRepository.findById(customer.getCustomerId()).isPresent());
    }
}



