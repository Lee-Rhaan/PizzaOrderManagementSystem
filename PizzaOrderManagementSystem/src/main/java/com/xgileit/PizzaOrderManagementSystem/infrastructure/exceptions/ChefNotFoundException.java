package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class ChefNotFoundException extends RuntimeException {

    public ChefNotFoundException(String message)
    {
        super(message);
    }
}
