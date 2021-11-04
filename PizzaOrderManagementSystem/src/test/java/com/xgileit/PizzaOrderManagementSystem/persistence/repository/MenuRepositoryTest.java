package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        Menu menu = new Menu("Vegan", "Large", "Water", "Large");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        menuRepository.deleteAll();
    }

    @Test
    void deleteMenuById() {
        //Given
        //When
        //Then
    }

    @Test
    void findMenuById() {
        //Given
        //When
        //Then
    }
}