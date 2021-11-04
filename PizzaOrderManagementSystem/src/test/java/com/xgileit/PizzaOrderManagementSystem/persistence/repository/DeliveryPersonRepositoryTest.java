package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DeliveryPersonRepositoryTest {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        deliveryPersonRepository.deleteAll();
    }

    DeliveryPerson deliveryPerson = new DeliveryPerson("King", "kingdom@gmail.com",
            "qwerty", "10111", "CPT");

    @Test
    void findDeliveryPersonById() {
        //Given
        //When
        //Then
    }
}