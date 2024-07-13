package com.desmond.ironhack.lab3._introtojpa.service;

import com.desmond.ironhack.lab3._introtojpa.model.Customer;
import com.desmond.ironhack.lab3._introtojpa.model.CustomerStatus;
import com.desmond.ironhack.lab3._introtojpa.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

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

    @Test
    public void testFindCustomerByName() {
        Customer customer = new Customer("Alice Johnson", CustomerStatus.SILVER, 2500);
        customerRepository.save(customer);
        List<Customer> foundCustomers = customerRepository.findByCustomerName("Alice Johnson");
        assertEquals(1, foundCustomers.size());
        assertEquals("Alice Johnson", foundCustomers.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomerByStatus() {
        customerRepository.save(new Customer("Bob Brown", CustomerStatus.GOLD, 4000));
        List<Customer> foundCustomers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertFalse(foundCustomers.isEmpty());
        assertEquals(CustomerStatus.GOLD, foundCustomers.get(0).getCustomerStatus());
    }
}



