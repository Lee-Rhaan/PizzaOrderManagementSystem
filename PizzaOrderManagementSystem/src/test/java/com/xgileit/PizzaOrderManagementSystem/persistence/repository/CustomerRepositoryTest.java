package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void findCustomerById() {
        //Given
        customerRepository.save(customer);

        //When
        Optional<Customer> expectedValue = customerRepository.findCustomerById(customer.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(customer));
    }
}