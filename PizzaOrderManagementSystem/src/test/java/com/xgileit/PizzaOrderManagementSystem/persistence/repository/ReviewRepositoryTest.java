package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions.ReviewNotFoundException;
import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
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
    private ReviewRepository reviewRepository;

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    Review review = new Review(5, "Experience was good");

    @Test
    void findReviewByIdTestSuccessful() {
        //Given
        reviewRepository.save(review);

        //When
        Optional<Review> expectedValue = reviewRepository.findReviewById(review.getReviewId());

        //Then
        assertThat(expectedValue).isEqualTo(Optional.of(review));
    }

    @Test
    void findReviewByIdTestNotSuccessful(){
        String message = "Review not found";

        //Given
        Exception expected = assertThrows(ReviewNotFoundException.class,
                () -> {throw new ReviewNotFoundException(message);});

        //Then
        assertEquals(message, expected.getMessage());
    }
}