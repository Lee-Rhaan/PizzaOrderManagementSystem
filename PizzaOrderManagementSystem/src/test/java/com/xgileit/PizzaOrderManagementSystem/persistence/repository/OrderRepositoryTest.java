package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        Order order = new Order("2", "4",
                "Vegan", "LARGE", "Water", "Large");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void deleteOrderById() {
        //Given
        //When
        //Then
    }

    @Test
    void findOrderById() {
        //Given
        //When
        //Then
    }
}