package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        managerRepository.deleteAll();
    }

    Manager manager = new Manager("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void findManagerById() {
        //Given
        //When
        //Then
    }
}