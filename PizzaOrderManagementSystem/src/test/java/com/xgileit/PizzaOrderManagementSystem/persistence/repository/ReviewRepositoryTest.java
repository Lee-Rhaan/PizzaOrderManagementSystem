package com.xgileit.PizzaOrderManagementSystem.persistence.repository;

import com.xgileit.PizzaOrderManagementSystem.persistence.model.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    //Before each test -> I want to create a new DeliveryPerson object
    @BeforeEach
    void setUp() {
        Review review = new Review(5, "Experience was good");
    }

    //After each test -> I want to delete everything
    //Which means for each test we'll have a clean slate
    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    @Test
    void findReviewById() {
        //Given
        //When
        //Then
    }
}