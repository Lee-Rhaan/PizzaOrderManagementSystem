package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message)
    {
        super(message);
    }
}
