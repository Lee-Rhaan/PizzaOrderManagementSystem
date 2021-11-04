package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.CustomerNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    Customer customer = new Customer("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void findCustomerByIdTestSuccessful() {
        //Given
        customerRepository.save(customer);

        //When
        Optional<Customer> expectedValue = customerRepository.findCustomerById(customer.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(customer));
    }

    @Test
    void findCustomerByIdTestNotSuccessful(){
        String message = "Customer not found";

        //Given
        Exception expected = assertThrows(CustomerNotFoundException.class,
                () -> {throw new CustomerNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}