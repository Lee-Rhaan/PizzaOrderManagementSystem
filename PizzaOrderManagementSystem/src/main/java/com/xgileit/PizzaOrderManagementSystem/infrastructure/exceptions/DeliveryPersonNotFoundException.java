package com.xgileit.PizzaOrderManagementSystem.infrastructure.exceptions;

public class DeliveryPersonNotFoundException extends RuntimeException {

    public DeliveryPersonNotFoundException(String message)
    {
        super(message);
    }
}
