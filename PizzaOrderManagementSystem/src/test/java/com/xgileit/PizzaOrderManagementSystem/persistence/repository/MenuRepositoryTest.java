package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        menuRepository.deleteAll();
    }

    Menu menu = new Menu("Vegan", "Large", "Water", "Large");

    @Test
    void deleteMenuById() {
        //Given
        //When
        //Then
    }

    @Test
    void findMenuById() {
        //Given
        menuRepository.save(menu);

        //When
        Optional<Menu> expectedValue = menuRepository.findMenuById(menu.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(menu));
    }
}