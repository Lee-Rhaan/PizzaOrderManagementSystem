package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ChefNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Chef;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.ChefRepository;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChefServiceTest {

    @Mock
    private ChefRepository chefRepository;

    @InjectMocks
    private ChefService chefService;

    @Mock
    private OrderRepository orderRepository;

    Chef chef = new Chef("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    @Test
    void loginTestSuccessful() {
        //When
        when(chefRepository.findChefById(chef.getId())).thenReturn(Optional.of(chef));

        //Then
        assertThat(chefService.login(chef.getId())).isEqualTo(chef);
    }

    @Test
    void loginTestNotSuccessful() {
        String message = "Chef not found";

        //Given
        Exception expected = assertThrows(ChefNotFoundException.class,
                () -> {throw new ChefNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void prepareOrderTest() {
        //When
        when(orderRepository.save(order)).thenReturn(order);

        //Then
        assertThat(chefService.prepareOrder(order)).isEqualTo(order);
    }
}