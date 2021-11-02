package com.xgileit.PizzaOrderManagementSystem.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rating; //out of 5
    private String feedback;
    @ManyToOne
    private Customer customerReview;

    public Review(Integer rating, String feedback)
    {
        this.rating = rating;
        this.feedback = feedback;
    }
}
