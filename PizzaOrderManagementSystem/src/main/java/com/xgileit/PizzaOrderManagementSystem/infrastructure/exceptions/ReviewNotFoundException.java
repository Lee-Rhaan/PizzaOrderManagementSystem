package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(String message)
    {
        super(message);
    }
}
