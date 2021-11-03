package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
