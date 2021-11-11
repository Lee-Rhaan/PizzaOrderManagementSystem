package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.OrderNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    Order order = new Order("2", "4",
            "Vegan", "LARGE", "Water", "Large");

    @Test
    void deleteOrderByIdTest() {
        //Given
        orderRepository.save(order);

        //When
        orderRepository.deleteOrderById(order.getId());
        boolean exists = orderRepository.existsById(order.getId());

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void findOrderByIdTestSuccessful() {
        //Given
        orderRepository.save(order);

        //When
        Optional<Order> expectedValue = orderRepository.findOrderById(order.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(order));
    }

    @Test
    void findOrderByIdTestNotSuccessful(){
        String message = "Order not found";

        //Given
        Exception expected = assertThrows(OrderNotFoundException.class,
                () -> {throw new OrderNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}