package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ManagerNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void findManagerByIdTestSuccessful() {
        //Given
        managerRepository.save(manager);

        //When
        Optional<Manager> expectedValue = managerRepository.findManagerById(manager.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(manager));
    }

    @Test
    void findManagerByIdTestNotSuccessful(){
        String message = "Manager not found";

        //Given
        Exception expected = assertThrows(ManagerNotFoundException.class,
                () -> {throw new ManagerNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}