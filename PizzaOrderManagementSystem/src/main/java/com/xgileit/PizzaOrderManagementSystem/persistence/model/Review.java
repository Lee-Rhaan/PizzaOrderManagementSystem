package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is the Review Entity class which will be mapped to the database.
 * This entity will store all the reviews in this Pizza Order System.
 */
@Data
@NoArgsConstructor
@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long reviewId;
    @Column(name = "rating")
    private Integer customerRating;
    @Column(name = "feedback")
    private String customerFeedback;

    @ManyToOne
    private Customer customerReview;

    public Review(Integer rating, String feedback)
    {
        this.customerRating = rating;
        this.customerFeedback = feedback;
    }
}
