package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.DeliveryPersonNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.DeliveryPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void findDeliveryPersonByIdTestSuccessful() {
        //Given
        deliveryPersonRepository.save(deliveryPerson);

        //When
        Optional<DeliveryPerson> expectedValue = deliveryPersonRepository.
                findDeliveryPersonById(deliveryPerson.getId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(deliveryPerson));
    }

    @Test
    void findDeliveryPersonByIdTestNotSuccessful(){
        String message = "Delivery Person not found";

        //Given
        Exception expected = assertThrows(DeliveryPersonNotFoundException.class,
                () -> {throw new DeliveryPersonNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}