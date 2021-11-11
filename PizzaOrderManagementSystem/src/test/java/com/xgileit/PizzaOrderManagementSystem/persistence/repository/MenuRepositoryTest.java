package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.MenuNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void deleteMenuByIdTest() {
        //Given
        menuRepository.save(menu);

        //When
        menuRepository.deleteMenuById(menu.getId());
        boolean exists = menuRepository.existsById(menu.getId());

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void findMenuByIdTestSuccessful() {
        //Given
        menuRepository.save(menu);

        //When
        Optional<Menu> expectedValue = menuRepository.findMenuById(menu.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(menu));
    }

    @Test
    void findMenuByIdTestNotSuccessful(){
        String message = "Menu not found";

        //Given
        Exception expected = assertThrows(MenuNotFoundException.class,
                () -> {throw new MenuNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}