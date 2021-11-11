package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.CustomerReviewNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.CustomerReview;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private CustomerReviewRepository customerReviewRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        customerReviewRepository.deleteAll();
    }

    CustomerReview customerReview = new CustomerReview(5, "Experience was good");

    @Test
    void findReviewByIdTestSuccessful() {
        //Given
        customerReviewRepository.save(customerReview);

        //When
        Optional<CustomerReview> expectedValue = customerReviewRepository.findReviewById(customerReview.getReviewId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(customerReview));
    }

    @Test
    void findReviewByIdTestNotSuccessful(){
        String message = "Review not found";

        //Given
        Exception expected = assertThrows(CustomerReviewNotFoundException.class,
                () -> {throw new CustomerReviewNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}