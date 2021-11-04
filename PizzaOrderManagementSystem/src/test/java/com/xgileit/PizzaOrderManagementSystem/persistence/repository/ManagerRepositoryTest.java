package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        Manager manager = new Manager("King", "kingdom@gmail.com",
                "qwerty", "10111", "CPT");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        managerRepository.deleteAll();
    }

    @Test
    void findManagerById() {
        //Given
        //When
        //Then
    }
}