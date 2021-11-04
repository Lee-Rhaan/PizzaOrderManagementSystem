package com.xgileit.PizzaOrderManagementSystem.api.service;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.DeliveryPersonNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import com.xgileit.PizzaOrderManagementSystem.persistence.repository.DeliveryPersonRepository;
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
class DeliveryPersonServiceTest {

    @Mock
    private DeliveryPersonRepository deliveryPersonRepository;

    @InjectMocks
    private DeliveryPersonService deliveryPersonService;

    @Mock
    private OrderRepository orderRepository;

    DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    @Test
    void loginTestSuccessful() {
        //When
        when(deliveryPersonRepository.findDeliveryPersonById(deliveryPerson.getId()))
                .thenReturn(Optional.of(deliveryPerson));

        //Then
        assertThat(deliveryPersonService.login(deliveryPerson.getId())).isEqualTo(deliveryPerson);
    }

    @Test
    void loginTestNotSuccessful() {
        String message = "Delivery Person not found";

        //Given
        Exception expected = assertThrows(DeliveryPersonNotFoundException.class,
                () -> {throw new DeliveryPersonNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }

    @Test
    void deliverOrder() {
        //When
        when(orderRepository.save(order)).thenReturn(order);

        //Then
        assertThat(deliveryPersonService.deliverOrder(order)).isEqualTo(order);
    }
}