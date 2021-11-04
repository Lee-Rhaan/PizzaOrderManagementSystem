package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryPersonRepositoryTest {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
                "qwerty", "10111", "CPT");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        deliveryPersonRepository.deleteAll();
    }

    @Test
    void findDeliveryPersonById() {
        //Given
        //When
        //Then
    }
}