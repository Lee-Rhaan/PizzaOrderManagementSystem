package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ChefRepositoryTest {

    @Autowired
    private ChefRepository chefRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        Chef chef = new Chef("King", "kingdom@gmail.com",
                "qwerty", "10111", "CPT");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        chefRepository.deleteAll();
    }

    @Test
    void findChefById() {
        //Given
        //When
        //Then
    }
}