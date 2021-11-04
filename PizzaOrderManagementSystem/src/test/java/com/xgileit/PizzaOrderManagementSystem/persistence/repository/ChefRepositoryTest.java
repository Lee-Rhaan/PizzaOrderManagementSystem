package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ChefRepositoryTest {

    @Autowired
    private ChefRepository chefRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        chefRepository.deleteAll();
    }

    Chef chef = new Chef("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void findChefByIdTestSuccessful() {
        //Given
        chefRepository.save(chef);

        //When
        Optional<Chef> expectedValue = chefRepository.findChefById(chef.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(chef));
    }
}